package com.lenovo.powersetting.utils;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ok on 5/26/14.
 */
public class ThreadUtils {
    public static void excu(Runnable runnable) {
        // Create a factory that produces daemon threads with a naming pattern and
        // a priority
        BasicThreadFactory factory = new BasicThreadFactory.Builder()
                .namingPattern("powersetting thread-%d")
                .daemon(true)
                .priority(Thread.MAX_PRIORITY)
                .build();
        // Create an executor service for single-threaded execution
        ExecutorService exec = Executors.newSingleThreadExecutor(factory);
        exec.submit(runnable);
    }

}
