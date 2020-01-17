package com.jacend.concurent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {

    static boolean flag = true;
    static Object lock = new Object();

    static class Wait implements Runnable {
        @Override
        public void run() {
            // 加锁，获得 lock 的 Monitor
            synchronized (lock) {
                // 当条件满足，继续 wait, 同时释放 lock 的锁
                while (flag) {
                    try {
                        System.out.println(String.format(Thread.currentThread() + " flag is ture " +
                                "wait@ " + new SimpleDateFormat("HH:mm:ss").format(new Date())));

                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 当条件满足， 完成工作
                System.out.println(String.format(Thread.currentThread() + " flag is ture " +
                        "running@ " + new SimpleDateFormat("HH:mm:ss").format(new Date())));

            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            // 加锁，获取 lock 的 Monitor
            synchronized (lock) {
                // 获得 lock 的锁，然后进行通知，通知时不会释放 lock 的锁
                // 直到当前线程释放了 lock 后，WaitThread 才能从 wait 方法中返回
                System.out.println(Thread.currentThread() + " hold lock, notify@ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again, notify@ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    public static void main(String[] args) {
        Thread waitThread = new Thread(new Wait(), "wait thread");
        waitThread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread notifyThread = new Thread(new Notify(), "notify thread");
        notifyThread.start();
    }
}
