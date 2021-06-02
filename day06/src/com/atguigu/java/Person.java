package com.atguigu.java;

import java.util.Objects;

/**
 * 用于测试Collection实现类的contains方法
 *
 * @author Meiko
 * @create 2021-06-02 20:51
 */
public class Person {

    private String name;
    private int age;

    public Person(){

    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

}
