package com.tobiassalem.creativejavaservice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tobias on 2017-02-01.
 */
public class TaskListServiceConfigurationTest {

    private static final int MAXLENGTH = 42;

    @Test
    public void listTasks() throws Exception {
        TaskListServiceConfiguration configuration = new TaskListServiceConfiguration();
        configuration.setMaxLength(MAXLENGTH);

        assertEquals(MAXLENGTH, configuration.getMaxLength());
    }
}