package com.example.javademo.reflection;

import com.example.javademo.pojo.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jiesi
 * @Description 通过反射创建对象
 * @Date 2021/8/5 3:18 下午
 */
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> c = Class.forName("com.example.javademo.pojo.User");
        // 相当于调用无参构造
        User user = (User) c.newInstance();
        System.out.println(user);

        // 通过构造器构建对象
        Constructor constructor = c.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        User user1 = (User) constructor.newInstance(1);
        System.out.println(user1);

        // 通过反射调用普通方法
        User user2 = (User) c.newInstance();
        Method setName = c.getDeclaredMethod("setName", String.class);
        // invoke 激活
        // 对应参数 （对象，参数值）
        setName.invoke(user2, "zhaos");
        System.out.println(user2);

        // 反射操作属性
        Field name = c.getDeclaredField("name");
        // 不能直接操作私有属性 需要关闭程序的安全检测
        name.setAccessible(true);
        name.set(user2, "jiesi");
        System.out.println(user2);
    }
}
