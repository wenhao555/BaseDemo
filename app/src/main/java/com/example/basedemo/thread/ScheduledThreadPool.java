package com.example.basedemo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool
{
    public static void main(String[] args)
    {
        startThread();
    }

    /**
     * 线程数固定
     * 可以进行定期执行任务
     */
    private static void startThread()
    {
        /**
         * 固定一个线程执行
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        for (int i = 1; i < 10; i++)
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
            /**
             * 延迟没5秒执行
             */
            scheduledExecutorService.schedule(runnable, 5, TimeUnit.SECONDS);
        }
    }
}
