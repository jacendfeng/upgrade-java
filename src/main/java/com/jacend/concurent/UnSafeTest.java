package com.jacend.concurent;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnSafeTest {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
    }
}
