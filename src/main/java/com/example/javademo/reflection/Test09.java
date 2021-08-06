package com.example.javademo.reflection;

import com.example.javademo.pojo.User;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author jiesi
 * @Description TODO
 * @Date 2021/8/5 5:24 下午
 */
public class Test09 {
    public static void main(String[] args) throws NoSuchMethodException {
        Class c = Test09.class;
        Method method = c.getDeclaredMethod("test01", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println(genericParameterType);
            if (genericParameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }

        method = c.getDeclaredMethod("test02", null);
        Type genericReturnType = method.getGenericReturnType();
        System.out.println(genericReturnType);
    }

    public static void test01(Map<String, Object> map, List<User> list) {
        System.out.println("test01");
    }

    public static Map<String, User> test02() {
        System.out.println("test02");
        return null;
    }
}
