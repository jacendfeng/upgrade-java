package com.jacend.singleton;

/**
 * 饿汉式：利用了 Java 初始化类加载机制，避免了并发问题，但是没有懒加载
 */
public class StraveSingleton {

    private static StraveSingleton singleton = new StraveSingleton();

    private StraveSingleton() {
    }

    public static StraveSingleton getStraveSingleton() {
        return singleton;
    }
}
