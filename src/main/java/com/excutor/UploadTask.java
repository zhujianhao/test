package com.excutor;

/**
 *
 * 此方法用来做上传**/
public class UploadTask implements Runnable{
    @Override
    public void run() {
        System.out.println(
                Thread.currentThread().getName()+":正在处理上传"
        );
    }
}
