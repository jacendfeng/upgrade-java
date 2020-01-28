package com.jacend.reflect;


import java.lang.reflect.Method;

public class TestDeep {

        public static void target(int i) {
            new Exception("#" + i).printStackTrace();
        }

        public static void main(String[] args) throws Exception {
            Class<?> klass = Class.forName("com.jacend.reflect.TestDeep");
            Method method = klass.getMethod("target", int.class);
            for (int i = 0; i < 20; i++) {
                method.invoke(null, i);
            }
        }
}
