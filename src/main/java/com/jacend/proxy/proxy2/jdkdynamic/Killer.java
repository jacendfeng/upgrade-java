package com.jacend.proxy.proxy2.jdkdynamic;

public class Killer implements Kill {

    @Override
    public void kill() {
        System.out.println("pong! Kill a man!");
    }
}
