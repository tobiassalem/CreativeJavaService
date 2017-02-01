package com.tobiassalem.creativejavaservice;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tobias on 2017-02-01.
 */
public class TaskTest {

    @Test
    public void getId() {
        Task t = buildTestTask();
        assertEquals(42, t.getId());
    }

    @Test
    public void getContent() {
        Task t = buildTestTask();
        assertEquals("My test task", t.getContent());
    }

    private Task buildTestTask() {
        return new Task(42, "My test task");
    }
}