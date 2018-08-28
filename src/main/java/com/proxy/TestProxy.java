package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestProxy {


    //为继承同一接口的某个方法做代理，可以在调用该方法前后做额外的操作（Aop）
    //从代理中获得对象
    public static void main(String[] args){
        ActiveProxy activeProxy= new ActiveProxy(new PrintIt());

        ProxyInter proxyInter = (ProxyInter)(Proxy.newProxyInstance(ProxyInter.class.getClassLoader(), new Class[]{ProxyInter.class,Extra.class},activeProxy));
//        proxyInter.print();
    }
}
