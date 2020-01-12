package com.jacend.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

    public static void iteratorWays() {
        HashMap<String, String> map = new HashMap();
        for (int i = 0; i < 10000; i++) {
            map.put("name" + i, "达利欧博" + i);
        }

        // 方式一 ： entrySet 遍历
        for (Map.Entry item : map.entrySet()) {
            System.out.println(item.getKey() + ":" + item.getValue());
        }

        // 方式二：iterator 遍历
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // 方式三：遍历所有的 key 和 value
        for (Object k : map.keySet()) {
            // 循环所有的 key
            System.out.println(k);
        }
        for (Object v : map.values()) {
            // 循环所有的值
            System.out.println(v);
        }

        // 方式四：通过 key 值遍历
        for (Object k : map.keySet()) {
            System.out.println(k + ":" + map.get(k));
        }

        // lambda 表达式方式
        map.forEach((K,V) -> System.out.println(K + ":" + V));
    }

    public static void main(String[] args) {
        iteratorWays();
    }
}
