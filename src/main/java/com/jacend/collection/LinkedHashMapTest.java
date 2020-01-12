package com.jacend.collection;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        map.put("b", "6");

        System.out.println(map);
    }
}
