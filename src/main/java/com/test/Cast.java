package com.test;

import org.junit.Test;

import javax.annotation.Resource;

public class Cast {

    @Test
    public void doubleCastToLong(){
        Long l= new Double("12.0").longValue();
        System.out.println(l);
    }
}
