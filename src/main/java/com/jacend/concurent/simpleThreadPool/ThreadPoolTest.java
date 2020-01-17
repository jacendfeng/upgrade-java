package com.jacend.concurent.simpleThreadPool;

import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    private static ThreadPool threadPool = new DefaultThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 399; i++) {
            threadPool.execute(new HelloJob());
        }
        TimeUnit.SECONDS.sleep(1);
        threadPool.shutdown();
        for (int i = 0; i < 399; i++) {
            threadPool.execute(new HelloJob());
        }
    }

    static class HelloJob implements Runnable {

        @Override
        public void run() {
            System.out.println("hello world" + System.currentTimeMillis());
            try {
                TimeUnit.MICROSECONDS.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
