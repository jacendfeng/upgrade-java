package com.jacend.singleton;

/**
 * 静态内部类的写法，这里跟饿汉的原理是一致的，利用了类加载机制，但是好的地方是可以延迟初始化
 */
public class Singleton {

    private Singleton() {
    }

    private static class SingletonInstance {
        private static final Singleton singleton = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.singleton;
    }
}
