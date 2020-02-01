package com.jacend.jvm;

public class ClassFile {

    private int m;

    private void sayHello() throws RuntimeException {
        System.out.println("say hello");
        if (m == 0) {
            throw new IllegalArgumentException("hoho");
        }
    }

    public static void main(String[] args) {
        ClassFile classFile = new ClassFile();
        classFile.sayHello();
    }
}
