package com.jacend.proxy.proxy2.jdkdynamic;

public class CruelWord {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.SaveGeneratedFiles", true);
        Killer killer = new Killer();
        Kill proxy = (Kill) KillerCountProxyFactory.getProxy(killer, new KillerCountInvocationHandler(new Killer()));
        proxy.kill();
        proxy.kill();
        proxy.kill();
        proxy.kill();
        proxy.kill();
        proxy.kill();
        proxy.kill();
        proxy.kill();
    }
}
