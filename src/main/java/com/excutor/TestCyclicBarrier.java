package com.excutor;

import org.junit.Test;

import java.util.concurrent.*;

/***/
public class TestCyclicBarrier {



    @Test
    public void test() throws InterruptedException {
        CyclicBarrier cyclicBarrier  =  new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有线程完成后执行这个线程" );
            }
        });
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new testRunnable(cyclicBarrier));
        executor.execute(new testRunnable(cyclicBarrier));
        executor.execute(new testRunnable(cyclicBarrier));
        //此处可以写个线程单独判断
        while(true){
            Thread.sleep(3000);
            if(!cyclicBarrier.isBroken()) {
                System.out.println("栅栏被打破啦");
                break;
            }
        }

        executor.shutdown();


    }

    class testRunnable implements Runnable{

        private CyclicBarrier cyclicBarrier ;

        private testRunnable(){}

       public  testRunnable(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier =  cyclicBarrier;
        }
        @Override
        public void run() {
            System.out.println("先休息2秒");
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "休息好了");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
