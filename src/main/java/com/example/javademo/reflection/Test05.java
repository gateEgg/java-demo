package com.example.javademo.reflection;

/**
 * @author jiesi
 * @Description 列举类加载器
 * @Date 2021/8/5 1:51 下午
 */
public class Test05 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        // 获取系统类加载器的父级->扩展加载器
        ClassLoader parent = systemClassLoader.getParent();
        // 获取扩展加载器的父级->根加载器 c/c++编写 无法获取到
        ClassLoader parent1 = parent.getParent();
        System.out.println(systemClassLoader);
        System.out.println(parent);
        System.out.println(parent1);

        // 测试当前类是由哪个加载器加载的
        Class<?> c1 = Class.forName("com.example.javademo.reflection.Test05");
        ClassLoader classLoader = c1.getClassLoader();
        System.out.println(classLoader);

        // 测试jdk内置类是由谁加载的
        Class<?> aClass = Class.forName("java.lang.String");
        ClassLoader classLoader1 = aClass.getClassLoader();
        System.out.println(classLoader1);

        // 获得系统类加载器可以加载的目录
        System.out.println(System.getProperty("java.class.path"));
    }
}
