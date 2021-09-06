package com.tobiassalem.creativejavaservice.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class OsUtilTest {

    @Test
    public void getTaskListCommandForOs() {
        if (isWindows()) {
            final String expected = "tasklist";
            final String actual = OsUtil.getTaskListCommandForOs();
            assertEquals(expected, actual);
        } else {
            final String expected = "ps -e";
            final String actual = OsUtil.getTaskListCommandForOs();
            assertEquals(expected, actual);
        }
    }

    private boolean isWindows() {
        return System.getProperty("os.name").contains("Windows");
    }

}