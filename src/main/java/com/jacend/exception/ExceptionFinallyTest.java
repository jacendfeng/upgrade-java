package com.jacend.exception;

public class ExceptionFinallyTest {


        public static void main(String[] args) {
            System.out.println("main 代码块中的执行结果为：" + myMethod());
        }

    /**
     * 如果当一个线程在执行 try 语句块或者 catch
     * 语句块时被打断（interrupted）或者被终止（killed），
     * 与其相对应的 finally 语句块可能不会执行。还有更极端的情况，
     * 就是在线程运行 try 语句块或者 catch 语句块时，突然死机或者断电，finally 语句块肯定不会执行了。
     * @return
     */
    public static int myMethod() {

            try {
                System.out.println("try 代码块被执行！");

                System.exit(0);

                return 0;
            } catch (Exception e) {
                System.out.println("catch 代码块被执行！");
                return 0;
            } finally {
                System.out.println("finally 代码块被执行！");
            }
        }}
