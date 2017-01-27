package com.tobiassalem.creativejavaservice;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by Tobias on 2017-01-27.
 */
public class TaskListServiceApplication extends Application<TaskListServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new TaskListServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "task-list-service";
    }

    @Override
    public void initialize(Bootstrap<TaskListServiceConfiguration> bootstrap) {
        // Placeholder method, nothing initialize at this stage.
    }

    @Override
    public void run(TaskListServiceConfiguration configuration, Environment environment) {
        // Register resource now
        final TaskListResource resource = new TaskListResource(configuration.getMaxLength());
        environment.jersey().register(resource);
    }
}
