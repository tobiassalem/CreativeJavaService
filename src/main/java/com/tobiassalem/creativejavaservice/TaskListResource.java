package com.tobiassalem.creativejavaservice;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;
import com.google.common.io.CharStreams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Tobias on 2017-01-27.
 */
@Path("/task-list")
@Produces(MediaType.APPLICATION_JSON)
public class TaskListResource {
    private static final int FIRST_LINE_TO_CONTAIN_DATA = 1;
    private final int maxLength;
    private final AtomicLong counter;
    Logger log = LoggerFactory.getLogger(TaskListResource.class);

    public TaskListResource(int maxLength) {
        this.maxLength = maxLength;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public List<Task> listTasks(@QueryParam("contains") Optional<String> contains) {
        List<Task> tasks = new ArrayList<Task>();
        String query = contains.or("");

        try {
            Process p = getProcessesFromTerminal(); 
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            List<String> lines = CharStreams.readLines(input);

            for (int i = FIRST_LINE_TO_CONTAIN_DATA; i < lines.size(); i++) {
                String line = lines.get(i);
                if (isContentToBeIncluded(line, query)) {
                    tasks.add(buildTask(line, maxLength));
                }
            }
            input.close();
        } catch (Exception e) {
            log.error("Exception in listTasks method.", e);
        }
        return tasks;
    }

    private Process getProcessesFromTerminal() throws IOException {
        return Runtime.getRuntime().exec("ps -e");
    }

    /**
     * Returns true if the content in line is to be included in the task list.
     * I.e. filter the processes depending on the ?contains= from the url
     * @param content - the line content to check
     * @param query - the query to search for
     * @return true if the line content is to be included, false otherwise
     */
    private boolean isContentToBeIncluded(final String content, final String query) {
        return content.contains(query);
    }


    /**
     * Builds a task with the given content and max length. I.e. trim the processes according to the maxLength
     * @param content
     * @param maxLength
     * @return Task object
     */
    private Task buildTask(final String content, final int maxLength) {
        return new Task(counter.getAndIncrement(), content.substring(0, Math.min(content.length(), maxLength)));
    }
}
