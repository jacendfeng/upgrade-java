package com.jacend.concurent;

public class SynchonizedTest {

    public synchronized void test() {
        System.out.println("test");
    }

    public void normal(){
        System.out.println("hjo");
    }
}
