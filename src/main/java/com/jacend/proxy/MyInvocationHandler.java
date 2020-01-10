package com.jacend.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object object) {
        super();
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---------- begin " + method.getName() + "----------");
        Object result = method.invoke(target, args);
        System.out.println("---------- end " + method.getName() + "----------");
        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    public static void main(String[] args) {
        HelloService service = new HelloServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(service);
        HelloService proxy = (HelloService) handler.getProxy();
        proxy.say();
    }
}
