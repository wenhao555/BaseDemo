package com.example.basedemo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool
{
    public static void main(String[] args)
    {
        startThread();
    }

    /**
     * CachedThreadPool 按需创建的线程池，没有核心线程，
     * 非核心线程有Integer.MAX_VALUE个
     * 每次提交任务如果有空线程则有空线程执行，没有空线程则创建空线程，
     * 适用于大量的需要立即处理且耗时短的任务
     */
    private static void startThread()
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++)
        {
            final int finali = i;
            Runnable runnable = new Runnable()
            {

                @Override
                public void run()
                {
                    try
                    {
                        Thread.sleep(1000);
                        System.out.println("run : " + finali + "  当前线程：" + Thread.currentThread().getName());
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(runnable);
            executorService.submit(runnable);
        }
    }
}
