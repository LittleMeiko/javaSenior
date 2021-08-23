package com.atguigu.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理举例
 */
interface Human {
    String getBelief();

    void eat(String food);
}

class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class ProxyFactory {

    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = method.invoke(obj, args);
        return returnValue;
    }
}

public class ProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxy = (Human) ProxyFactory.getProxyInstance(superMan);
        //String belief = proxy.getBelief();
        //System.out.println(belief);
        System.out.println("我替超人接广告...");
        proxy.eat("牛肉");
        System.out.println("我替超人做广告...");
    }
}
