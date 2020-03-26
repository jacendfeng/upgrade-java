package com.jacend.proxy.proxy2.cglibdynamic;

import com.jacend.proxy.proxy2.jdkdynamic.Killer;
import net.sf.cglib.core.DebuggingClassWriter;

public class DoCGLib {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/jacend/Code/private/learn_design_code/upgrade-java/src/main/resources");

        CglibProxyFactory proxy = new CglibProxyFactory();
        //通过生成子类的方式创建代理类
        Killer proxyImp = (Killer)proxy.getProxy(Killer.class, new KillMethodInterceptor());
        proxyImp.kill();
        proxyImp.kill();
        proxyImp.kill();
        proxyImp.kill();
        proxyImp.kill();
    }
}
