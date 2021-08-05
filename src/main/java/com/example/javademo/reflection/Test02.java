package com.example.javademo.reflection;

import java.lang.annotation.ElementType;

/**
 * @author jiesi
 * @Description 所有类型的class
 * @Date 2021/8/5 9:46 上午
 */
public class Test02 {
    public static void main(String[] args) {
        // 对象
        Class c1 = Object.class;
        // 接口
        Class c2 = Comparable.class;
        // 一维数组
        Class c3 = String[].class;
        // 二维数组
        Class c4 = int[][].class;
        // 注解
        Class c5 = Override.class;
        // 枚举
        Class c6 = ElementType.class;
        // 空
        Class c7 = void.class;
        // 基本类型
        Class c8 = Integer.class;
        // Class
        Class c9 = Class.class;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);

        // 只要元素类型与维度一样 就是同一个class
        int[] a = new int[1];
        int[] b = new int[11];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());
    }
}
