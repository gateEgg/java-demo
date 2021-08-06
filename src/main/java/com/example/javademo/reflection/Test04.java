package com.example.javademo.reflection;

/**
 * @author jiesi
 * @Description 会引发类初始化与不会引发的例子
 * @Date 2021/8/5 11:13 上午
 */
public class Test04 {
    static {
        System.out.println("main🥱初始化");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 会引发类初始化
        // 新建类
//        Son son = new Son();
        // 通过反射
//        Class.forName("com.example.javademo.reflection.Son");

        // 不会引发的
        // 通过子类调用父类的静态变量，不会导致子类初始化
//        System.out.println(Son.f);
        // 引用常量不会触发此类的初始化
//        System.out.println(Son.M);
        // 通过数组定义引用 不会触发
        Son[] sons = new Son[2];
    }
}

class Father {
    static {
        System.out.println("父类初始化");
    }

    static int f = 1;
}

class Son extends Father {
    static {
        System.out.println("子类初始化");
    }
    static int s = 2;
    final static int M = 3;
}