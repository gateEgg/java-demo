package com.example.javademo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiesi
 * @Description TODO
 * @Date 2021/8/4 4:29 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    public Integer age;

    private User (int id) {
        this.id = id;
    }
}
