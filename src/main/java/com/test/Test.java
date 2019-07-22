package com.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

import jxl.Cell;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.read.biff.PasswordException;

/***/
public class Test {


    public static void main(String[] args){
        Map<String,String> map = new HashMap();
        map.put("key1","value1");
        map.put("key2","value2");
        StringBuilder s = new StringBuilder();

        for(String key :map.keySet()){
            if(s.length()>0) {
                s.append(";");
            }
            s.append(key);
            s.append(":");
            s.append(map.get(key));
        }
        System.out.println(s.toString());


    }


    public static String escapeChar(int x) {
        if (x <= 0x7f) {
            return Character.toString((char) x);
        } else {
            return "\\u" + String.format("%04x", x);
        }
    }

    public static String escape(String in) {
        return in.chars().mapToObj(x -> escapeChar(x)).collect(Collectors.joining());
    }

    class Corp{
        private String corpName;
        private String corpId;
        private String hosCode;

        public String getCorpName() {
            return corpName;
        }

        public void setCorpName(String corpName) {
            this.corpName = corpName;
        }

        public String getCorpId() {
            return corpId;
        }

        public void setCorpId(String corpId) {
            this.corpId = corpId;
        }

        public String getHosCode() {
            return hosCode;
        }

        public void setHosCode(String hosCode) {
            this.hosCode = hosCode;
        }
    }




}


