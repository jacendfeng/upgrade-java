package com.jacend.concurent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static class Soldier implements Runnable {

        private String soilder;
        private final CyclicBarrier cyclic;

        Soldier(CyclicBarrier cyclic, String soilderName) {
            this.cyclic = cyclic;
            this.soilder = soilderName;
        }

        @Override
        public void run() {
            try {
                cyclic.await();
                doWork();
            } catch (InterruptedException | BrokenBarrierException exception) {
                exception.printStackTrace();
            }
        }

        void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soilder + ": 任务完成");
        }
    }

    public static class BarrierRun implements Runnable {

        boolean flag;
        int N;

        public BarrierRun(boolean flag, int N) {
            this.flag = flag;
            this.N = N;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("司令:[士兵" + N + "个任务完成！]");
            } else {
                System.out.println("司令:[士兵" + N + "个集合完成！]");
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        final int N = 10;
        Thread[] allSoldier = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new BarrierRun(false, N));

        // 设置屏障点，主要是为了执行这个方法
        System.out.println("队伍集合");
        for (int i = 0; i < N; i++) {
            System.out.println("士兵 " + i + "报道！");
            allSoldier[i] = new Thread(new Soldier(cyclicBarrier, "士兵" + i));
            allSoldier[i].start();
         }
    }
}
