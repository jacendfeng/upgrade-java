package com.jacend.proxy.speed;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest implements InvocationHandler {

    private Test target;

    private DynamicProxyTest(Test target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }

    public static Object getProxy(Test target) {
        return (Test) Proxy.newProxyInstance(
                DynamicProxyTest.class.getClassLoader(),
                new Class<?>[] { Test.class },
                new DynamicProxyTest(target)
        );
    }
}
