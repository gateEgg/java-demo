package com.example.javademo.reflection;

import com.example.javademo.annotation.MyAnnotation;

import java.lang.annotation.Annotation;

/**
 * @author jiesi
 * @Description 反射操作注解
 * @Date 2021/8/5 6:10 下午
 */
@MyAnnotation
public class Test10 {

    public static void main(String[] args) {
        Class<Test10> c = Test10.class;
        Annotation[] annotations = c.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

    }
}
