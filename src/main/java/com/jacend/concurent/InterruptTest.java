package com.jacend.concurent;

import java.util.concurrent.TimeUnit;

public class InterruptTest {

    static class SleepRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class BusyRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("我被打断了，哈哈，我得自己处理这个中断");
                }
            }
        }
    }

    public static void main(String[] args) {
        // sleep Thread 不停尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "sleep thread");
        sleepThread.setDaemon(true);

        // busyThread 不停的运行
        Thread busyThread = new Thread(new BusyRunner(), "busy thread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sleepThread.interrupt();
        busyThread.interrupt();


        System.out.println("sleep thread interrupted is " + sleepThread.isInterrupted());
        System.out.println("busy thread interrupted is " + busyThread.isInterrupted());

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
