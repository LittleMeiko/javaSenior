package com.atguigu.java4;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类的测试
 *
 * @author Meiko
 * @date 2021-09-03
 */
public class OptionalTest {

    //创建对象
    @Test
    public void test1() {
        Girl girl = new Girl();
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);

        Optional<Girl> girl1 = Optional.of(girl);
        System.out.println(girl1);

        girl = null;
        Optional<Girl> girl2 = Optional.ofNullable(girl);
        System.out.println(girl2);
    }

    @Test
    public void test2() {
        Boy boy = new Boy();
        boy = null;
        String name = OptionalTest.getName(boy);
        System.out.println(name);
    }

    public static String getName(Boy boy) {
        Optional<Boy> boy1 = Optional.ofNullable(boy);
        Boy boy2 = boy1.orElse(new Boy(new Girl("高圆圆")));

        Girl girl = boy2.getGirl();
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        Girl girl2 = girl1.orElse(new Girl("于京京"));

        return girl2.getName();
    }
}
