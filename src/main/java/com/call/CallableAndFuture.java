package com.call;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.lang.System.out;


public class CallableAndFuture {
    public static void main(String[] args) {

        FutureTask<Integer> future = new FutureTask<Integer>(()->{
            Thread.sleep(5000);// 可能做一些事情
            return new Random().nextInt(100);});
        new Thread(future).start();
        try {

            out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


    @Test
    public  void test() {

        ExecutorService threadPool= Executors.newSingleThreadExecutor();
        Future<Integer> future = threadPool.submit(()->new Random().nextInt(100));
        try {
            boolean flag = true;
           while (flag){
               if(future.isDone()){
                   flag = false;
               }
           }
            out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }



}
