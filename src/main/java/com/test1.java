package com;

import com.yuantu.common.lang.StringUtils;
import org.junit.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class test1 {


    @Test
    public void test(){

        Long l=new Double(100.00).longValue();
        long ls=Long.valueOf("100.00");

        System.out.println(l);
        System.out.println(ls);
    }


    @Test
    public void toPutong(){
        String s = "1111110050.50006";
        s =formate(s);
        String[] s1= toUp(s);
        String preChar = "";
        String result = "";
        int size = s1.length;
        for(int i= template.length-1; i>=0 ;i--){
            if(size==0){
                break;
            }
            size = size-1;

            if(s1.length-size<4){
                if(s1[size].equals(".")){
                    i++;
                    continue;
                }
                if(s1[size].equals("零")){
                    continue;
                }
                result+=template[i];
                result+=s1[size];
                continue;
            }

            if((s1.length-size)==4){

                if(s1[size].equals("零")){
                    result+=template[i];
                    continue;
                }
                result+=template[i];
                result+=s1[size];
                continue;
            }


            if(org.apache.commons.lang.StringUtils.equals(preChar,s1[size])&&preChar.equals("零")){
                continue;
            }
            preChar = s1[size];
            if(s1[size].equals("零")){
                result+=s1[size];
                continue;
            }

            result+=template[i];
            result+=s1[size];

        }

        //倒序输出
        System.out.println(backout(result));

    }

    public static String formate(String s){
        Double d = Double.valueOf(s);
        DecimalFormat format = new DecimalFormat(".00");
        return format.format(d);
    }

    public static String[] template={"万","仟","佰","拾","亿","仟","佰","拾","万","仟","佰","拾","圆","角","分"};

    public static String[] toUp(String source){
        String[] s= source.split("");
        for(int i= 0 ;i<s.length ;i++) {
            switch (s[i]) {
                case "0":
                    s[i]="零";
                    break;
                case "1":
                    s[i]="壹";
                    break;
                case "2":
                    s[i]="贰";
                    break;
                case "3":
                    s[i]="叁";
                    break;
                case "4":
                    s[i]="肆";
                    break;
                case "5":
                    s[i]="伍";
                    break;
                case "6":
                    s[i]="陆";
                    break;
                case "7":
                    s[i]="柒";
                    break;
                case "8":
                    s[i]="捌";
                    break;
                case "9":
                    s[i]="玖";
                    break;
                case ".":
                    break;
            }
        }
        return s;
    }


    private String backout(String s){
        String[] c= s.split("");
        String res= "";
        for(int i=c.length-1;i>=0;i--){
            res+=c[i];
        }
        return res;
    }

}
