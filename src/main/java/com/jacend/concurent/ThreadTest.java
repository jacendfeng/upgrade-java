package com.jacend.concurent;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

    /**
     * 优先级设置是不可靠的，因为还是得底层操作系统去调度
     * 并且有的操作系统是没有那么多优先级给你对应的
     */
    public static void priorityTest() {
        Thread t = Thread.currentThread();
        System.out.println("Main Thread Priority:" + t.getPriority());

        Thread t1 = new Thread();
        System.out.println("Thread 1 Priority:" + t1.getPriority());
        t1.setPriority(Thread.MAX_PRIORITY - 1);
        System.out.println("Thread 1 Priority:" + t1.getPriority());

        t.setPriority(Thread.NORM_PRIORITY);
        System.out.println("Main Thread Priority:" + t.getPriority());

        Thread t2 = new Thread();
        System.out.println("Thread 2 Priority:" + t2.getPriority());

        // change thread t2 priority to minimum
        t2.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Thread 2 Priority:" + t2.getPriority());

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用于程序后台和支持性工作
     * 当 JVM 不存在非 Daemon 线程时候，JVM 将会推出
     *
     * 值得注意的是，在Daemon线程中产生的新线程也是Daemon的。
     */
    public static void daemonThread() {
        Thread childThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("I'm child thread..");
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // 正常先设置是否是守护线程再启动
        childThread.setDaemon(true);
        childThread.start();
        // start 之后再设置 IllegalThreadStateException 会报错 但是程序会继续跑
        // childThread.setDaemon(true);
        System.out.println("I'm main thread...");
    }

    public static void main(String[] args) {
        // priorityTest();
        daemonThread();
    }
}
