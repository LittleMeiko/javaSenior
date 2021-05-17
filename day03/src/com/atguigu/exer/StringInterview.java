package com.atguigu.exer;

/**
 * String类常见面试题之一
 *
 * @author Meiko
 * @create 2021-05-17 21:42
 */
public class StringInterview {

    String str = new String("good");
    char[] ch = {'t','e','s','t'};

    public void change(String str, char[] ch) {
        str = "hello";
        ch[0] = 'g';
    }

    public static void main(String[] args) {
        StringInterview test = new StringInterview();
        test.change(test.str,test.ch);
        System.out.println(test.str);
        System.out.println(test.ch);
    }
}
