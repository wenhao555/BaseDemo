package com.example.basedemo.thread;

import android.util.Log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool
{
    public static ThreadPool getInstance()
    {
        return new ThreadPool();
    }

    public static void main(String[] args)
    {
        startThread();
    }

    /**
     * 线程池的优点
     * 池中的线程不会 立刻销毁 会继续等待另外的任务 不会频繁销毁创建线程
     * 邮箱控制线程池中的并发苏
     * 对多个线程进行管理 可提供定时执行和指定间隔循环执行的功能
     */
    private static void startThread()
    {
        /**
         * 线程池中的核心线程数量
         * 线程池中的最大线程数量
         * 非核心线程的超时时长
         * 超市的参数单位
         */
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(4,
                        5,
                        1,
                        TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>(50)
                );

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
//            executor.execute(runnable);
            executor.submit(runnable);
        }
    }

}
