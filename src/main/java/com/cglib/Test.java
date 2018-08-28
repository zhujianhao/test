package com.cglib;

import net.sf.cglib.proxy.Enhancer;

/***/
public class Test {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Print.class);
        enhancer.setCallback(new CgProxy());
        Print p = (Print)enhancer.create();
        p.p();
    }


}
