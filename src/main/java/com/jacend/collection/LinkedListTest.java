package com.jacend.collection;

import java.util.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("bird");
        list.add("cat");
        list.add("dog");

        System.out.println(list.peek());

        System.out.println(list.poll());

        list.offer("summer");

        System.out.println(list);
    }
}
