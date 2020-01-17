package com.jacend.concurent;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class TestHarness {

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(() -> {
                try {
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }

        long start = System.nanoTime();
        System.out.println(LocalDateTime.now());
        // release 所有的都开始
        startGate.countDown();
        // Causes the current thread to wait until the latch has counted down to zero 主线程等着
        endGate.await();
        long end = System.nanoTime();
        System.out.println(LocalDateTime.now());
        return end - start;
    }

    public static void main(String[] args) throws InterruptedException {
        TestHarness testHarness = new TestHarness();
        long gapTime = testHarness.timeTasks(45, new Runnable() {
            @Override
            public void run() {
                System.out.println("sun haha");
            }
        });
        System.out.println(gapTime);
    }
}
