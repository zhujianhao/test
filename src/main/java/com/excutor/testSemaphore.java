package com.excutor;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/***/
public class testSemaphore {
    private static Semaphore semaphore =new Semaphore(2);
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(7);
    public static void main(String[] args) throws IOException {
        Runnable r1 = new Runnable() {
            public void run() {

                System.out.println("name" + Thread.currentThread().getName());
                try {
                    for(int i =0 ;i<3;i++) {
                        System.out.println("新一轮等待");
                        cyclicBarrier.await();

                        System.out.println("新一轮开始");
                        protec();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }
        };

        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();

        System.in.read();
    }

    public static final void protec(){

        try {
            semaphore.acquire();
            System.out.println("正在运行的是"+Thread.currentThread().getName() );
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

}
