package com.jacend.collection;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {

    public static void main(String[] args) {
        // 插入顺序
        LinkedHashMap<String, String> map = new LinkedHashMap(16,0.75f, false);
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");

        System.out.println(map);

        // 按照 access 的顺序
        LinkedHashMap<String, String> map2 = new LinkedHashMap(16,0.75f, true);
        map2.put("a", "1");
        map2.put("b", "2");
        map2.put("c", "3");

        map2.get("b");
        System.out.println(map2);
    }
}
