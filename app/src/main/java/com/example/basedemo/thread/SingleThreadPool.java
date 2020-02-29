package com.example.basedemo.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool
{
    public static void main(String[] args)
    {
        startThread();
    }

    /**
     * Single单线程池，只有一个核心线程，没有非核心线程
     * 如果没有运行线程则创建一个线程执行，如果正在运行则加入队列等待。
     * 一个任务一个任务的执行
     */
    private static void startThread()
    {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
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
        }
    }
}
