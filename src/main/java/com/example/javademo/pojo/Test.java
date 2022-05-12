package com.example.javademo.pojo;

/**
 * @author jiesi
 * @Description TODO
 * @Date 2021/8/19 4:56 下午
 */
public class Test<S, T> {

    public Test() {

    }

    public void test(S s, T t) {
        System.out.println(getClass());
    }

}
