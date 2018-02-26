package com.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ActiveProxy implements InvocationHandler {

    private Object print;

    public ActiveProxy(ProxyInter print) {
        this.print = print;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print("在打印前，我动态代理了一下");
        return method.invoke(print,args);
    }
}
