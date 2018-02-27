package com.kinds;

import com.alibaba.fastjson.JSON;
import com.kinds.AppleFormateImp.RedApple;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FileTest {

    public void testFileHidden() {
//        File[] hiddenFiles = new File("C:\\Program Files (x86)").listFiles(new FileFilter() {
//            public boolean accept(File file) {
//                return file.isHidden();
//            }
//        });
        File[] hiddenFiles = new File("C:\\Program Files (x86)").listFiles(File::isHidden);
        System.out.println("长度："+hiddenFiles.length);
    }




    public static void main(String args[]){
//        FileTest fileTest=new FileTest();
//        fileTest.testFileHidden();



        List<Apple> list= new ArrayList<Apple>();
        list.add(new Apple("red",1000));
        list.add(new Apple("green",500));

//        List<Apple> result=list.stream().filter((Apple a)->a.getWeight()>200)
//                            .collect(Collectors.toList());

        AppleFilter appleFilter=new AppleFilter();
        List<Apple> result=appleFilter.filter(list,(Apple a)->a.getColor().equals("red"));

        list.sort((Apple a1,Apple a2)->Float.compare(a1.getWeight(),a2.getWeight()));
        List<String> s0=list.stream().map(Apple::getColor).collect(toList());
        s0.stream().forEach(System.out::println);
        String s=JSON.toJSONString(s0);
        System.out.println(s);


    }
}
