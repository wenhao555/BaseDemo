package com.example.basedemo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class FixedThreadPool
{
    public static FixedThreadPool getInstance()
    {
        return new FixedThreadPool();
    }

    public static void main(String[] args)
    {
        startFixedThreadPool();
    }

    /**
     * Fixed线程池 是可重用的线程池
     * 只有核心线程,没有非核心线程
     * 核心线程不会被回收
     * 无界队列方式来运行
     * 有任务时 有空闲的核心线程则用核心线程执行，没有的话则加入队列
     */
    private static void startFixedThreadPool()
    {
        /**
         * 处理 线程的数量固定是10
         */
        ExecutorService pool
                = Executors.newFixedThreadPool(10);
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
            pool.submit(runnable);//会返回一个Future对象
        }
    }
}
