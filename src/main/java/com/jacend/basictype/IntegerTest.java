package com.jacend.basictype;

public class IntegerTest {

    public static void change(Integer i) {
        i = 89090;
    }

    public static void main(String[] args) {
        Integer i = 129;
        Integer a = Integer.valueOf(129);
        System.out.println(i == a);
    }
}
