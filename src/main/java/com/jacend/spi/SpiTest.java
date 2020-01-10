package com.jacend.spi;

import java.util.ServiceLoader;

public class SpiTest {

    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        for (IShout s : shouts) {
            s.shout();
        }
    }
}
