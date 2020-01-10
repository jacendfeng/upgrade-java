package com.jacend.singleton;

/**
 * 写法简单，
 * 线程安全，枚举中 static
 *
 * Java 专门做了规定 防止序列化时候，仅仅将 name 属性输出到结果中 反序列化时候（java.lang.Enum.valueOf 通过 name 查找对象 而不是新建一个对象）
 * 防止发射破坏，反射 newInstance 里面会检查是不是枚举类型  参考 @Constructor 类 newInstance 方法 throw new IllegalArgumentException("Cannot reflectively create enum objects");
 */
public enum  EnumSingleton {

    INSTACE;
}
