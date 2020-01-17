package com.jacend.concurent;

import java.util.concurrent.*;

public class CreateThreadTest {

    // Thread or Runnable 就不说了
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 从 JDK 1.5 开始，可以通过 Callable 和 FutureTask 创建线程
        CallableThread callableThread = new CallableThread();
        FutureTask futureTask = new FutureTask(callableThread);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

        System.out.println(Thread.currentThread().getName());
        System.out.println("通过线程池创建线程");
        ExecutorService executorService
                = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
    }

    static class CallableThread implements Callable {

        @Override
        public Object call() throws Exception {
            System.out.println(Thread.currentThread().getName());
            return "sunshine";
        }
    }
}
