package com.jacend.proxy.proxy2.cglibdynamic;

import com.jacend.proxy.proxy2.jdkdynamic.KillerCount;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * MethodInterceptor 方法拦截器
 */
public class KillMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("kill man count to:" + KillerCount.incr());
        return result;
    }
}
