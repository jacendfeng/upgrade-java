package com.jacend.proxy;

public class HelloServiceImpl implements HelloService {

    @Override
    public void say() {
        System.out.println("Hello world!");
    }

    @Override
    public void add() {
        System.out.println("-----------add------------");
    }
}
