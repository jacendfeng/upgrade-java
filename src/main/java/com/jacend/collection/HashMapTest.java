package com.jacend.collection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class HashMapTest {

    public static void resizeTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        HashMap map = new HashMap(8);
//        for (int i = 0; i < 64; i++) {
//            map.put(i, i+1);
//        }

        map.put(1, "jacend");
        map.put(2, "jklkl;");
        map.put(3, "jklkl;");
        map.put(4, "jklkl;");
        map.put(5, "jklkl;");
        map.put(6, "jklkl;");

        System.out.println(hash(1));
        System.out.println(hash(2));
        System.out.println(hash(3));
        System.out.println(hash(4));
        System.out.println(hash(5));
        System.out.println(hash(6));
        System.out.println(hash(7));
        System.out.println(hash(8));

        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));

        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(map));

        HashMap<String, String> map1 = new HashMap();
        System.out.println("capacity : " + capacity.invoke(map1));
        map1.put("name", "jacend");
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

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
        // map.forEach((K,V) -> System.out.println(K + ":" + V));
    }

    public static void hashCodeEqualsTest() {
        Apple apple1 = new Apple("red");
        Apple apple2 = new Apple("yellow");

        HashMap<Apple, Integer> map = new HashMap<>();
        map.put(apple1, 1);
        map.put(apple2, 2);

        System.out.println(map.get(new Apple("red")));
    }

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        resizeTest();
    }

    static class Apple {
        private String color;

        public Apple(String color) {
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Apple apple = (Apple) o;
            return Objects.equals(color, apple.color);
        }

        // @Override
        // public int hashCode() {
        //     return Objects.hash(color);
        // }
    }
}
