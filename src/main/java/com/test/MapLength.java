package com.test;

import java.util.*;

/***
 *@Author: zjh
 *@Date: Created on 13:41 2019/10/14
 *@Modofy by:
 * 一个二位数组，每个元素都可以往上下左右四个方向走，寻找最长递增路径。如下图所示，最长递增路径即红色字体路径。白纸写代码。
 */
public class MapLength {

    private static  Integer[][] integers = {{1,2,3,4,5},{2,5,4,3,2},{3,6,5,1,2},{4,2,6,3,7},{5,3,5,6,8}};

    private List<Node> resList = new ArrayList<>();
    class Node{
        private Node nextNode;
        private Integer length;


    }



    private static void walk(Integer cow,Integer column){
        Map.Entry<Integer ,Integer> entry = new AbstractMap.SimpleEntry(cow,column);

        if(cow>=1&&cow<=5&&column>=1&&column<=5) {
            Integer data = integers[cow][column];

            //left
            if ((column - 1) >= 1) {
                if ((data++).equals(integers[cow][column-1])){

                    walk(cow,column-1);

                }
            }
            //right
            if ((column + 1) <= 5) {
                if ((data++).equals(integers[cow][column+1])){

                    walk(cow,column+1);
                }
            }
            //up
            if ((cow - 1) >= 1) {
                if ((data++).equals(integers[cow-1][column])){
                    walk(cow-1,column);
                }
            }
            //down
            if ((cow + 1) <= 5) {
                if ((data++).equals(integers[cow+1][column])){

                    walk(cow+1,column);
                }
            }
        }
    }

    public static void main(String[] args) {
        for(int i = 1 ;i<=5;i++){
            for(int j = 1 ;j<=5;j++){

            }
        }
    }

}
