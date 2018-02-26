package com.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class t  =  MethodClass.class;
        Method[] methods= t.getDeclaredMethods();
        for(Method e:methods){
            System.out.println(e.getName());
        }
        Field fields=t.getDeclaredField("name");
        System.out.print(fields.getName());
//        for(Field e:fields){
//            System.out.println(e.getName());
//        }

        Object o = t.newInstance();
        fields.setAccessible(true);
        fields.set(o,"ccc");
        System.out.println(fields.get(o));
    }


}
