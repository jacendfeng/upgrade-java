package com.jacend.init;

public class Son extends Father {

    public static int toyNumber;

    {
        toyNumber = 55;
    }

    private boolean isGoodSon;

    @Override
    public void say() {
        System.out.println("I am son");
    }

    public static void main(String[] args) {
        System.out.println(Son.toyNumber);
        System.out.println(Coco.a);
        System.out.println(Coco.b);
        System.out.println(Coco.c);
        System.out.println(Father.str);


        Father father = new Son();
        father.say();
    }
}
