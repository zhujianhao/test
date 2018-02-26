package com;

import org.junit.Test;

import java.math.BigDecimal;

public class test1 {


    @Test
    public void test(){

        Long l=new Double(100.00).longValue();
        long ls=Long.valueOf("100.00");

        System.out.println(l);
        System.out.println(ls);
    }
}
