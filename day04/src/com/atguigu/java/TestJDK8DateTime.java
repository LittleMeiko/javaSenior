package com.atguigu.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * JDK8中的日期
 *
 * 为什么JDK8要推出新的日期时间API：
 *  1.可变性：日期和时间这样的类应该是不可变的，但在Calendar中设置后会改变原来的日期
 *  2.偏移性：Date中的年份都是从1900年开始的，月份都是从0开始的，使用不方便
 *  3.格式化：格式化只对Date有用，而Calend不行
 *  4.线程安全问题：Date和Calendar不是线程安全的，而且也不能处理闰秒
 *
 * @author Meiko
 * @create 2021-05-27 21:10
 */
public class TestJDK8DateTime {

    @Test
    public void test1() {
        //new一个表示今天日期的Date
        Date date1 = new Date(2020, 5, 27);
        //实际却不是今天的日期
        System.out.println(date1);//Sun Jun 27 00:00:00 CST 3920
        //Date中的年份都是从1900年开始的，月份都是从0开始的
        Date date2 = new Date(2020 - 1900, 5 - 1, 27);
        System.out.println(date2);//Wed May 27 00:00:00 CST 2020
    }

    /**
     *  LocalDate、LocalTime、LocalDateTime的使用
     */
    @Test
    public void test2() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println("*********************");

        //体现偏移性
        LocalDateTime localDateTime1 = LocalDateTime.of(2012, 8, 8, 8, 8, 8);
        System.out.println(localDateTime1);
        System.out.println("*********************");

        LocalDateTime localDateTime2 = LocalDateTime.now();
        System.out.println(localDateTime2.getYear());
        System.out.println(localDateTime2.getMonthValue());
        System.out.println(localDateTime2.getDayOfMonth());
        System.out.println(localDateTime2.getHour());
        System.out.println(localDateTime2.getMinute());
        System.out.println(localDateTime2.getSecond());
        System.out.println("*********************");

        //体现不可变性
        LocalDateTime localDateTime3 = LocalDateTime.now();
        LocalDateTime localDateTime4 = localDateTime3.withDayOfMonth(10);
        System.out.println(localDateTime3);//2021-05-27T21:37:42.141
        System.out.println(localDateTime4);//2021-05-10T21:37:42.141
        LocalDateTime localDateTime5 = localDateTime3.plusMonths(3);
        System.out.println(localDateTime3);
        System.out.println(localDateTime5);
        LocalDateTime localDateTime6 = localDateTime3.minusYears(2);
        System.out.println(localDateTime3);
        System.out.println(localDateTime6);

    }

    /**
     * Instant类的使用
     */
    @Test
    public void test3() {
        //获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);
        //获取修正时区后的时间
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取毫秒数 相当于Date的getTime()
        long l = instant.toEpochMilli();
        System.out.println(l);//1622123563859
        //获取指定瞬时点的日期对象 相当于 new Date(long time)
        Instant instant1 = Instant.ofEpochMilli(1622123563859L);
        System.out.println(instant1);
    }

    /**
     * DateTimeFormatter类的使用：解析/格式化日期 相当于 SimpleDateFormat()
     */
    @Test
    public void test4() {
        //方式一：使用预定义的标准格式
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();
        String str1 = formatter.format(now);
        System.out.println(now);//2021-05-27T22:04:24.864
        System.out.println(str1);//2021-05-27T22:04:24.864
        TemporalAccessor parse = formatter.parse("2021-05-27T22:04:24.864");
        System.out.println(parse);//{},ISO resolved to 2021-05-27T22:04:24.864
        System.out.println("****************************");

        //方式二：使用本地化相关的格式
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String str2 = formatter1.format(now);
        System.out.println(str2);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);
        System.out.println("****************************");

        //方式三：使用自定义格式
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str4 = formatter3.format(now);
        System.out.println(str4);//2021-05-27 10:16:11
        TemporalAccessor parse1 = formatter3.parse("2012-08-08 08:08:08");
        System.out.println(parse1);
    }
}
