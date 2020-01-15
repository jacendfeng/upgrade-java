package com.jacend.collection.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerSample {

    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(100);
        Producer p = new Producer(queue);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}

class Producer implements Runnable {

    private final BlockingQueue queue;

    Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(500);
                queue.put(produce());
                System.out.println("produce one");
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    Object produce() {
        return new Object();
    }
}

class Consumer implements Runnable {

    private final BlockingQueue queue;

    Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                consumer(queue.take());
                System.out.println("consume one");
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

    void consumer(Object x) {

    }
}
