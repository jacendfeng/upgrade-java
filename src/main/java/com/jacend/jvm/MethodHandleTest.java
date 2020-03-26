package com.jacend.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {

    static class ClassA {
        public void println(String s) {
            System.out.println(s);
        }
    }

    private static MethodHandle getPrintlnMH(Object receiver) throws NoSuchMethodException, IllegalAccessException {
        // MethodType 代表方法类型，包含了方法的返回值（第一个参数）和具体参数（第二个及以后的参数）
        MethodType mt = MethodType.methodType(void.class, String.class);
        // lookup 方法来自于 MethodHandles.lookup，这句的作用是在指定类中查找符合给定的方法名称、方法类型以及符合调用权限的方法句柄
        // 因为这里调用的是一个虚方法，按照 Java 语言的规则，方法的第一个参数是隐式，代表该方法的接受者，即是 this 指向的对象
        // 这个方法以前是放在参数列表中进行传递，现在提供了 bindTo
        return MethodHandles.lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        // 无论 obj 最终是哪个实现类，下面这句都能正确调用到 println 方法
        getPrintlnMH(obj).invokeExact("hello");
    }
}
