package com.atguigu.java;

/**
 * 静态代理举例
 */
interface ClothFactory {
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory {

    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂为生产衣服做一些准备工作...");
        clothFactory.produceCloth();
        System.out.println("代理工作做一些后续处理工作...");
    }
}


//被代理类
class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服...");
    }
}

public class StaticProxyTest {

    public static void main(String[] args) {
        ClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);
        proxyClothFactory.produceCloth();
    }
}
