package com.jacend.collection.queue;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue delayQueue = new DelayQueue();
        delayQueue.put(new DelayElement(1000));
        delayQueue.put(new DelayElement(3000));
        delayQueue.put(new DelayElement(5000));
        System.out.println("开始时间：" +  DateFormat.getDateTimeInstance().format(new Date()));
        while (!delayQueue.isEmpty()){
            System.out.println(delayQueue.take());
        }
        System.out.println("结束时间：" +  DateFormat.getDateTimeInstance().format(new Date()));
    }
}

class DelayElement implements Delayed {

    // 延迟截止时间（单位：毫秒）
    long delayTime = System.currentTimeMillis();

    public DelayElement(long delayTime) {
        this.delayTime = this.delayTime + delayTime;
    }

    // 获取剩余时间
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(
                delayTime - System.currentTimeMillis()
                , TimeUnit.MILLISECONDS);
    }

    // 队列里元素排序的依据
    @Override
    public int compareTo(Delayed o) {
        if (this.getDelay(TimeUnit.MICROSECONDS) > o.getDelay(TimeUnit.MICROSECONDS)) {
            return 1;
        } else if (this.getDelay(TimeUnit.MICROSECONDS) < o.getDelay(TimeUnit.MICROSECONDS)) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return DateFormat.getDateTimeInstance().format(new Date(delayTime));
    }
}
