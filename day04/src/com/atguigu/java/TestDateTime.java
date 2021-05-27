package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Meiko
 * @create 2021-05-27 20:32
 */
public class TestDateTime {

    /**
     * java8之前的日期SimpleDateFormat
     *
     * @throws ParseException
     */
    @Test
    public void test() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr = sdf.format(new Date());
        System.out.println(dateStr);

        Date date = sdf.parse("2012-08-08 08:08:08");
        System.out.println(date);
    }

    /**
     * java8之前的日期Calendar
     */
    @Test
    public void test1() {
        Calendar calendar = Calendar.getInstance();
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);

        calendar.set(Calendar.DAY_OF_MONTH,15);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        calendar.add(Calendar.DAY_OF_MONTH, 3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        calendar.add(Calendar.DAY_OF_MONTH, -3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        Date date1 = calendar.getTime();
        System.out.println(date1);

        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
    }
}
