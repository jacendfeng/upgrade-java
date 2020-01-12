package com.jacend.collection;

import java.util.Collection;
import java.util.HashSet;

public class HashSetTest {

    public static void main(String[] args) {
        Collection<String> hashset = new HashSet<>();
        String sun1 = "sun";
        String sun2 = "sun";
        System.out.println(sun1 == sun2);
        System.out.println(hashset.add(sun1));
        System.out.println(hashset.add(sun2));
    }
}
