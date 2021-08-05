package com.example.javademo.reflection;

import lombok.Getter;

/**
 * @author jiesi
 * @Description 测试创建类的方式
 * @Date 2021/8/4 4:40 下午
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person s = new Student();
        System.out.println(s.getName());

        Person t = new Teacher();
        System.out.println(t.getName());

        // 通过Object的getClass方法创建
        Class<? extends Person> c1 = s.getClass();
        // 通过 Class.forName 包名创建
        Class<?> c2 = Class.forName("com.example.javademo.reflection.Student");
        // 通过类.class获得
        Class<Student> c3 = Student.class;
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        // 基本内置类型的包装类都有一个TYPE属性
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);
        System.out.println(type.hashCode());
    }
}

@Getter
class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}

class Student extends Person {
    public Student() {
        super("学生");
    }
}

class Teacher extends Person {
    public Teacher() {
        super("老师");
    }
}