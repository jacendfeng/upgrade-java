package com.jacend.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        // 设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        // 通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置代理");
        Object result = methodProxy.invokeSuper(obj, args);
        System.out.println("后置代理");
        return result;
    }

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        HelloServiceImpl proxyImp = (HelloServiceImpl) proxy.getProxy(HelloServiceImpl.class);
        proxyImp.add();
    }
}
