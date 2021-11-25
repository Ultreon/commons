package com.ultreon.commons.crash;

import com.ultreon.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public final class ApplicationCrash {
    private static final List<Runnable> crashHandlers = new ArrayList<>();
    private final CrashLog crashLog;

    ApplicationCrash(CrashLog crashLog) {
        this.crashLog = crashLog;
    }

    public void printCrash() {
        String crashString = this.crashLog.toString();
        List<String> strings = StringUtils.splitIntoLines(crashString);
        for (String string : strings) {
            System.err.println(string);
        }
    }

    private void crash() {
        for (Runnable handler : crashHandlers) {
            handler.run();
        }
    }

    public static void onCrash(Runnable handler) {
        crashHandlers.add(handler);
    }

    public CrashLog getCrashLog() {
        return crashLog;
    }
}
