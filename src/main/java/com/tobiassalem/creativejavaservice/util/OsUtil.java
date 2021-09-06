package com.tobiassalem.creativejavaservice.util;

public class OsUtil {

    private static String OS = null;

    public static String getOsName() {
        if (OS == null) {
            OS = System.getProperty("os.name");
        }
        return OS;
    }

    public static boolean isWindows() {
        return getOsName().startsWith("Windows");
    }


    /**
     * Get the applicable task list command for the current OS.
     * NB! Naive implementation for now (assume non-Windows is Linux compatible).
     * @return
     */
    public static String getTaskListCommandForOs() {
        if (isWindows()) {
            return "tasklist";
        } else {
            return "ps -e";
        }
    }

}
