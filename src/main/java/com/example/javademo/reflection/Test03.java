package com.example.javademo.reflection;

/**
 * @author jiesi
 * @Description TODO
 * @Date 2021/8/5 11:00 上午
 */
public class Test03 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }
}

/**
 * m = 10
 * m = 20
 * 两个初始化合并了 交换顺序之后m值会变化
 */
class A {
    static {
        m = 10;
        System.out.println("A类静态代码块");
    }

    static int m = 20;

    public A() {
        System.out.println("A类无参构造");
    }
}
