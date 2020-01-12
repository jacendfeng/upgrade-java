package com.jacend.collection;

import java.util.ArrayList;
import java.util.List;

public class IteratorTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>() {{
                add("java");
                add("java 虚拟机");
                add("java 中文社群");
        }};

        // JDK8 增加的支持 lambda 表达式的遍历方式
        list.iterator().forEachRemaining(item -> System.out.println(item));
    }
}
