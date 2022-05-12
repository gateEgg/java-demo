package com.example.javademo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@SpringBootTest
class JavaDemoApplicationTests {

    @Test
    void contextLoads() {
    }





}

class Zhaos<S, T> {

    public Zhaos() {

    }

    public void test(S s, T t) {

        Class <T> entityClass = (Class <T>)  ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        Class<?>[] declaredClasses = getClass().getDeclaredClasses();
        for (Class<?> declaredClass : declaredClasses) {
            System.out.println(declaredClass);
        }

        System.out.println(this.getClass());

        System.out.println(s.getClass());

    }

    @Test
    void test01() {
        int i = 0;
        String s = "s";
        Zhaos<Integer, String> zhaos = new Zhaos<>();
        zhaos.test(i, s);
    }

}

class GT1 extends GT2<Integer>{
    public static void main(String[] args) {
        System.out.println(((ParameterizedType)new GT1().getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}

class GT2<T> {

}