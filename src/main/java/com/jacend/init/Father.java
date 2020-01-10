package com.jacend.init;

public class Father {

    public static String name;
    public static int age;

    public static char c;
    public static String str = "I am the king of the world";

    private boolean isGoodFather;

    {
        name = "john";
        age = 32;
    }

    public void say() {
        System.out.println("I am father");
    }
}
