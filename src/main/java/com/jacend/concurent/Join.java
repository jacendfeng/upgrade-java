package com.jacend.concurent;

import java.util.concurrent.TimeUnit;

public class Join {

    static class Domino implements Runnable {

        private Thread thread;
        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                // thread 线程加入到当前线程，thread 线程完毕，当前线程才能往下走
                // 所以 main 方法的代码是，最后是 9 等 8 ，8 等 7 最后是 0 等 main,
                // main 执行完 0 开始执行
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminated.");
         }

        public static void main(String[] args) {
            Thread previous = Thread.currentThread();
            for (int i = 0; i < 10; i++) {
                // 每个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
                Thread thread = new Thread(new Domino(previous), String.valueOf(i));
                thread.start();
                previous = thread;
            }

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " terminate");
        }
    }
}
