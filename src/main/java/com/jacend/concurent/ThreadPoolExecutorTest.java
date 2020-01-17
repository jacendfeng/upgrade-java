package com.jacend.concurent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build();


    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,
                20,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue(10),
                namedThreadFactory,
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().hashCode());
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }
}
