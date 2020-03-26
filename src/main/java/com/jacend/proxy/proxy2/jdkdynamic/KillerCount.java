package com.jacend.proxy.proxy2.jdkdynamic;

import java.util.concurrent.atomic.AtomicInteger;

public class KillerCount {

    static AtomicInteger count = new AtomicInteger();

    public static int incr() {
        return count.incrementAndGet();
    }
}
