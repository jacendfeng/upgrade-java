package com.jacend.collection.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueTest {

    public static void main(String[] args) {
        // 默认非公平锁是实现
        ArrayBlockingQueue queue1 = new ArrayBlockingQueue(6);
        // 公平阻塞队列
        ArrayBlockingQueue queue2 = new ArrayBlockingQueue(6, true);
    }
}
