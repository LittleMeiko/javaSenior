package com.atguigu.java;

/**
 * 使用enum关键字创建枚举类,定义的枚举类默认继承于 java.lang.Enum
 *
 *  Enum类中的常用方法:
 *  values()：返回枚举类型的对象数组。遍历所有的枚举值
 *  valueOf(String objName)：返回枚举类中对象名为objName的对象
 *  toString()：返回当前枚举类对象常量的名称
 *
 *  使用enum关键字定义枚举类实现接口的情况：
 *  1.实现接口，在enum类中实现抽象方法
 *  2.让枚举类的每个对象分别去实现接口中的抽象方法
 *
 * @author Meiko
 * @date 2021-05-31
 */
public class EnumTest {

    public static void main(String[] args) {
        System.out.println(SeasonEnum.class.getSuperclass());// class java.lang.Enum
        SeasonEnum spring = SeasonEnum.SPRING;
        System.out.println(spring.toString());
        System.out.println("**************************");

        SeasonEnum[] values = SeasonEnum.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }
        System.out.println("**************************");

        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }
        System.out.println("**************************");

        //返回枚举类中对象名为objName的对象
        SeasonEnum winter = SeasonEnum.valueOf("WINTER");
        //如果没有名为objName的枚举类对象，则抛出异常：IllegalArgumentException
//        SeasonEnum winter = SeasonEnum.valueOf("WINTER1");
        System.out.println(winter);
    }
}

enum SeasonEnum implements demo{
    //1.提供当前枚举类的多个对象
    SPRING("春天", "穿暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("粉红色的记忆");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    //2.声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造方法并给对象属性赋值
    private SeasonEnum(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.提供获取枚举类属性的get()及toString()
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public String toString() {
//        return "SeasonEnum{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }


//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }
}

interface demo {
    void show();
}
