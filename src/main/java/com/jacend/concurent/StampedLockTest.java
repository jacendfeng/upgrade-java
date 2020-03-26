package com.jacend.concurent;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {
}

class Point {
    private double x,y;
    private final StampedLock sl = new StampedLock();

    void move(double delataX, double deltaY) {
        long stamp = sl.writeLock();
        try {
            x += delataX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    double distanceFromOrigin() {
        // 乐观读
        long stamp = sl.tryOptimisticRead();
        double currentX = x, currentY = y;

        // 验证版本号是否有变化
        if (!sl.validate(stamp)) {
            // 版本号变了，乐观读转悲观读
            stamp = sl.readLock();
            try {
                // 重新读取 x,y 的值
                currentX = x;
                currentY = y;
            } finally {
                // 释放读锁，需要传入上面获取的版本
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }


    void moveIfAtOrigin(double newX, double newY) {
        // 获取悲观读锁
        long stamp = sl.readLock();
        try {
            while (x == 0.0 && y == 0.0) {
                // 转为写锁
                long ws = sl.tryConvertToWriteLock(stamp);

                // 转换成功
                if (ws != 0L) {
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                } else {
                    // 装换失败
                    sl.unlockRead(stamp);
                    // 获取写锁
                    stamp = sl.writeLock();
                }
            }
        } finally {
            // 释放锁
            sl.unlock(stamp);
        }
    }
}
