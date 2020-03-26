package com.jacend.proxy.proxy2.cglibdynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz, MethodInterceptor methodInterceptor){
        // 设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(methodInterceptor);
        // 通过字节码技术动态创建子类实例
        return enhancer.create();
    }
}
