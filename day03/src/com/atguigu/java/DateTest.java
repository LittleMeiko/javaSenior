package com.atguigu.java;

import org.junit.Test;

import java.util.Date;

/**
 *  java.util.Date
 *      |---java.sql.Date
 *
 * @author Meiko
 * @create 2021-05-25 21:42
 */
public class DateTest {

    @Test
    public void test1() {
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        Date date2 = new Date(1621951138416L);
        System.out.println(date2.toString());

        java.sql.Date date3 = new java.sql.Date(1621951138416L);
        System.out.println(date3);

        Date date4 = new java.sql.Date(1621951138416L);
        System.out.println(date4);
        java.sql.Date date5 = (java.sql.Date)date4;
        System.out.println(date5);
    }
}
