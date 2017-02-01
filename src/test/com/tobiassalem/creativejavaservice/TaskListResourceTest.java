package com.tobiassalem.creativejavaservice;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Supplier;
import org.junit.Test;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Tobias on 2017-02-01.
 */
public class TaskListResourceTest {

    private static final int MAXLENGTH = 42;

    @Test
    public void listTasks() throws Exception {
        TaskListResource resource = new TaskListResource(MAXLENGTH);
        List<Task> tasks = resource.listTasks(Optional.of(""));
        assertNotNull(tasks);
        assertEquals(1, tasks.size());
    }

    @Test
    public void listTasksWithContains() throws Exception {
        TaskListResource resource = new TaskListResource(MAXLENGTH);
        List<Task> tasks = resource.listTasks(Optional.of("frodo"));
        assertNotNull(tasks);
        assertEquals(0, tasks.size());
    }

}