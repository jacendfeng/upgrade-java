package com.jacend.concurent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorsTest {

    public static void main(String[] args) {
        ExecutorService s1 = Executors.newFixedThreadPool(10);
        ExecutorService s2 = Executors.newCachedThreadPool();

        ExecutorService s3 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService s4 = Executors.newScheduledThreadPool(10);
    }
}
