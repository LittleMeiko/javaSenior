package com.atguigu.java;

/**
 * 枚举类：类的对象只有有限个，确定的，称此类为枚举类。当需要定义一组常量时，强烈建议使用枚举类.
 * 定义枚举类的方式：
 *   1.JDK5.0之前自定义枚举类
 *   2.JDK5.0以后可使用enum关键字
 *
 * @author Meiko
 * @date 2021-05-31
 */
public class CustomEnumTest {

    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }

}

//自定义枚举类
class Season {
    //1.声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造方法并给对象属性赋值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3.提供当前枚举类的多个对象
    public static final Season SPRING = new Season("春天", "穿暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冰天雪地");

    //4.提供获取枚举类属性的get()及toString()
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
