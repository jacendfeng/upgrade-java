package com.jacend.basictype;

public class StringTest {

    /**
     * Integer 与 String 互相转换的问题
     */
    public static void transform() {
        Integer i = 5;

        // 这里字节码编译之后实际上就是 StringBuilder.append 方法最后再调用 toString 方法
        String s1 = "" + i;

        // 内部调用的就是 return Integer.toString(i);
        String s2 = String.valueOf(i);

        // TODO: 这个具体的实现挺有意思的，可以网上进行一些搜索里面 getChar 方法的实现
        String s3 = Integer.toString(i);
    }


    /**
     * 字符串拼接的问题
     * 1、如果不是在循环体中进行字符串拼接的话，直接使用+就好了，
     *   而在循环体内，不要求线程安全的情况下要使用 StringBuilder.append 方法
     * 因为会频繁创建 StringBuilder 对象，耗时耗内存资源
     * 2、如果在并发场景中进行字符串拼接的话，要使用StringBuffer来代替StringBuilder。
     */
    public static void concat() {
        // 现实原理是创建一个字符数组，长度是已有字符串和待拼接字符串的长度之和
        // 再把两个字符串的值复制到新的字符数组中，并使用这个字符数组创建一个新的 String 对象并返回
        String s = "abcd";
        s = s.concat("ef");

        // Java 语法糖，编译之后就是 StringBuilder.append 方法
        String wechat = "jacend";
        String introduce = "每日更新 Java 相关技术文章";
        String jacend = wechat + "," + introduce;


    }

    public static void internTest() {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);

        String s5 = new String("feng");
        String s6 = "feng";
        String s7 = "fe" + "ng";
        System.out.println(s6 == s7);
    }


    public static void main(String[] args) {
        internTest();
    }
}