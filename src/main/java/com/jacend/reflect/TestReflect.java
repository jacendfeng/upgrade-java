package com.jacend.reflect;


import java.io.Serializable;
import java.lang.reflect.*;

public class TestReflect implements Serializable {

    // 通过一个对象获得完整的包名和类名
    public static void getClassName() {
        TestReflect testReflect = new TestReflect();
        System.out.println(testReflect.getClass().getName());
    }

    // 实例化 Class 对象
    public static void initObj() throws ClassNotFoundException {
        Class cl1 = Class.forName("com.jacend.reflect.TestReflect");
        Class cl2 = new TestReflect().getClass();
        Class cl3 = TestReflect.class;
        System.out.println("class name: " + cl1.getName());
        System.out.println("class name: " + cl2.getName());
        System.out.println("class name: " + cl3.getName());
    }

    public static void getParentAndImplInterface() throws ClassNotFoundException {
        // 获取一个对象的父类与实现的接口
        Class clazz = Class.forName("com.jacend.reflect.TestReflect");
        Class parentClass = clazz.getSuperclass();
        System.out.println("parent class name: " + parentClass.getName());

        // 获取所有的接口
        Class inters[] = clazz.getInterfaces();
        System.out.println("clazz implement interfaces: ");
        for (int i = 0; i < inters.length; i++) {
            System.out.println((i + 1) + ":" + inters[i]);
        }
    }

    public static void instantiate() throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        // 第一种方法，实例化默认构造函数，调用 set 赋值
        Class cloudClass = Class.forName("com.jacend.reflect.Cloud");
        Cloud cloud = (Cloud) cloudClass.newInstance();
        cloud.setHeight(1000);
        cloud.setSize(500000);
        System.out.println(cloud);

        // 第二种方法，取得全部构造函数，使用构造函数赋值
        Constructor[] cons = cloudClass.getConstructors();
        // 查看每个构造函数需要的参数
        for (int i = 0; i < cons.length; i++) {
            Class[] clz = cons[i].getParameterTypes();
            System.out.print("cons[" + i + "] (");
            for (int j = 0; j < clz.length; j++) {
                if (j == clz.length - 1) {
                    System.out.print(clz[j].getName());
                } else {
                    System.out.print(clz[j].getName() + ",");
                }
            }
            System.out.println(")");
        }

        for (Constructor con : cons) {
            if (con.getParameterCount() == 0) {
                cloud = (Cloud) cons[0].newInstance();
                System.out.println(cloud);
            }
        }
    }

    public static void getAllProperties() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.jacend.reflect.Cloud");
        System.out.println("======================本类属性=================");

        Field[] fields = clazz.getDeclaredFields();
        getAp(fields);

        System.out.println("============实现的接口或者父类的属性=============");
        Field[] fields1 = clazz.getFields();
        getAp(fields1);
    }

    private static void getAp(Field[] fields1) {
        for (int j = 0; j < fields1.length; j++) {
            int mo = fields1[j].getModifiers();
            String priv = Modifier.toString(mo);

            // 属性类型
            Class<?> type = fields1[j].getType();
            System.out.println(priv + " " + type.getName() + " " + fields1[j].getName() + ";");
        }
    }

    public static void getAllMethod() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.jacend.reflect.Cloud");
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Class<?> returnType = methods[i].getReturnType();
            Class<?>[] para = methods[i].getParameterTypes();
            int temp = methods[i].getModifiers();
            System.out.print(Modifier.toString(temp) + " ");
            System.out.print(returnType.getName() + " ");
            System.out.print(methods[i].getName() + " ");
            System.out.print("(");

            for (int j = 0; j < para.length; ++j) {
                System.out.print(para[j].getName() + " " + "arg" + j);
                if (j < para.length - 1) {
                    System.out.print(",");
                }
            }
            Class<?> exce[] = methods[i].getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(") throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
        }
    }

    public static void invokeMehthod() throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InstantiationException,
            InvocationTargetException, NoSuchFieldException {
        Class<?> clazz = Class.forName("com.jacend.reflect.Cloud");

        Method method = clazz.getMethod("getHeight");
        method.invoke(clazz.newInstance());

        Method method1 = clazz.getMethod("sayWhatIwantToSay", String.class);;
        method1.invoke(clazz.newInstance(), "我是一个大人物");

        Cloud cloud = (Cloud) clazz.newInstance();
        Field field = clazz.getDeclaredField("height");
        field.setAccessible(true);
        field.set(cloud, 980);
        System.out.println(field.get(cloud));
    }

    public static void modifyArray() {
        int[] temp = {1,2,34,4,5,6};
        Class<?> demo = temp.getClass().getComponentType();
        System.out.println("数组类型 " + demo.getName());
        System.out.println("数组长度 " + Array.getLength(temp));
        System.out.println("数组的第一个元素 " + Array.get(temp, 0));
        Array.set(temp, 0, 100);
        System.out.println("修改之后数组的" +
                "第一个元素为：" + Array.get(temp, 0));
    }

    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            InvocationTargetException,
            NoSuchMethodException, NoSuchFieldException {
        // getAllProperties();
        // getAllMethod();
        // invokeMehthod();
        modifyArray();
    }
}
