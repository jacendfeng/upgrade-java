package com.jacend.proxy.proxy2.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class KillerCountProxyFactory {

    public static Object getProxy(Kill target, InvocationHandler invocationHandler) {
        return Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), invocationHandler);
    }
}
