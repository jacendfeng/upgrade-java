package com.jacend.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest {

    public static void main(String[] args) {
        // Arrays.asList 返回的是 Arrays 里面一个静态内部类，无法增删，可以遍历，get set
        List<String> list = Arrays.asList("jacend", "feng");
        // throw exception java.lang.UnsupportedOperationException
        list.add("jkljk");

        // 使用
        List<String> canModiferList = new ArrayList<>(list);
        canModiferList.add("jkjlkj");
    }
}
