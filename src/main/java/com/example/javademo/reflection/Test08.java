package com.example.javademo.reflection;

import com.example.javademo.pojo.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jiesi
 * @Description 测试性能
 * @Date 2021/8/5 4:23 下午
 */
public class Test08 {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        test1();
        test2();
        test3();
    }

    /**
     * 传统方法调用
     */
    public static void test1() {
        User user = new User();
        long s = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        long e = System.currentTimeMillis();
        System.out.println(e - s);
    }

    /**
     * 反射调用
     */
    public static void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class<User> userClass = User.class;
        Method getName = userClass.getDeclaredMethod("getName");
        long s = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }
        long e = System.currentTimeMillis();
        System.out.println(e - s);
    }

    /**
     * 反射调用 关闭安全检测
     */
    public static void test3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class<User> userClass = User.class;
        Method getName = userClass.getDeclaredMethod("getName");
        getName.setAccessible(true);
        long s = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }
        long e = System.currentTimeMillis();
        System.out.println(e - s);
    }

}
