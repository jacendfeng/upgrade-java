package com.jacend.singleton;

/**
 * 懒汉式: 线程不安全
 */
public class LazySingleton {

    private static LazySingleton singleton;

    private LazySingleton(){

    }

    public static LazySingleton getLazySingleton() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
