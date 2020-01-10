package com.jacend.spi;

public class Cat implements IShout {

    @Override
    public void shout() {
        System.out.println("喵喵喵");
    }
}
