package com.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

import com.node.Node;
import jxl.Cell;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.read.biff.PasswordException;

/***/
public class Test {


    public static void main(String[] args){
        List<String> linkLisk = new LinkedList<>();

        linkLisk.add("afdfdggddgfdfefv");
        linkLisk.add("bsdsdfsffsd");
        Collections.sort(linkLisk);
        System.out.println(linkLisk.toString());
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


    @org.junit.Test
    public void readTree(){
        Node rootnode = new Node(
                new Node(new Node(null,null,"4"),new Node(null,null,"5"),"2"),
                new Node(new Node(new Node(null,null,"8"),new Node(null,null,"9"),"6"),new Node(new Node(null,null,"10"),new Node(null,null,"11"),"7"),"3"),
                "1");
        stack1.push(rootnode.getLc());
        stack1.push(rootnode.getRc());
        System.out.println(rootnode.getDate());
        readStack1();


    }
    private static Stack<Node> stack1= new Stack();

    private static Stack<Node> stack2 = new Stack();
    private static void readStack1(){
        while(true) {
            if (stack1.isEmpty()){
                return;
            }
            Node node = stack1.pop();
            if(node!=null) {

                stack2.push(node.getRc());
                stack2.push(node.getLc());
                System.out.println(node.getDate());
            }
            if (stack1.isEmpty()){
                break;
            }
        }
        readStack2();
    }

    private static void readStack2(){
        while(true) {
            if (stack2.isEmpty()){
                return;
            }
            Node node = stack2.pop();
            if(node!=null) {
                stack1.add(node.getLc());
                stack1.add(node.getRc());

                System.out.println(node.getDate());
            }
            if (stack2.isEmpty()){
                break;
            }
        }
        readStack1();
    }




}


