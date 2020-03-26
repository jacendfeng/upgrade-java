package com.jacend.proxy.proxy2.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class KillerCountInvocationHandler implements InvocationHandler {

    private Kill target;

    public KillerCountInvocationHandler (Kill kill) {
        this.target = kill;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Kill man count to:" + KillerCount.incr());
        Object result = method.invoke(target, args);
        return result;
    }
}
