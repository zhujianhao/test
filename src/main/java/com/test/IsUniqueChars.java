package com.test;

import org.junit.Test;

public class IsUniqueChars {

    @Test
    public  void isUniqueChars() {
        System.out.println(Integer.toBinaryString(1 <<-32));
        System.out.println(Integer.toBinaryString(1 <<-1));
        System.out.println(Integer.toBinaryString(1 <<-33).length());
        int checker = 0;
        String str="abCd";
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0) {
                System.out.println("false");
            }
            checker |= (1 << val);
        }
        System.out.println("true");
    }


}