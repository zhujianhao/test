package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestProxy {

    public static void main(String[] args){
        ActiveProxy activeProxy= new ActiveProxy(new PrintIt());

        ProxyInter proxyInter = (ProxyInter)(Proxy.newProxyInstance(ProxyInter.class.getClassLoader(), new Class[]{ProxyInter.class},activeProxy));
        proxyInter.print();
    }
}
