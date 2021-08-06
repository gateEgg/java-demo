package com.example.javademo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author jiesi
 * @Description 通过反射可以获得的类的属性
 * @Date 2021/8/5 2:45 下午
 */
public class Test06 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c = Class.forName("com.example.javademo.pojo.User");
        // 获取类名 包名+类名
        System.out.println(c.getName());
        // 获取类名 只有类名
        System.out.println(c.getSimpleName());

        System.out.println("=========================");
        System.out.println("获取类的属性");
        // 获取类的属性 只能找到public的
        Field[] fields = c.getFields();
        System.out.println("getFields:");
        for (Field field : fields) {
            System.out.println(field);
        }
        // 获取类的属性 能找到所有的
        Field[] declaredFields = c.getDeclaredFields();
        System.out.println("declaredFields:");
        for (Field field : declaredFields) {
            System.out.println(field);
        }
        System.out.println("=========================");
        // 获得指定属性 public
        Field name = c.getField("age");
        System.out.println(name);

        Field name1 = c.getDeclaredField("name");
        System.out.println(name1);

        System.out.println("=========================");
        // 获取类的方法 本类及父类的所有public
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println("getMethods：" + method);
        }
        // 本类的所有方法
        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("getDeclaredMethods：" + method);
        }
        // 获取指定方法
        // 之所以传入参数是因为有重载的情况
        Method getName = c.getDeclaredMethod("getName", null);
        System.out.println(getName);

        Method setName = c.getDeclaredMethod("setName", String.class);
        System.out.println(setName);

        // 获取构造器 public
        Constructor[] constructors = c.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("getConstructors:" + constructor);
        }
        // all
        Constructor[] declaredConstructors = c.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("getDeclaredConstructors:" + declaredConstructor);
        }
        // 区分包装类和基本类型
        Constructor constructor = c.getDeclaredConstructor(int.class);
        System.out.println(constructor);
    }
}
