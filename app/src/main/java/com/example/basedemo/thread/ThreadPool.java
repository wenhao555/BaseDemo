package com.example.basedemo.thread;

import android.util.Log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
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
         * 超时的参数单位
         * Thread
         */
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(4,
                        5,
                        1,
                        TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>(50)
                        , new RejectedExecutionHandler()
                {
                    @Override
                    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor)
                    {
                        //丢回来的任务线程
                    }
                });

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

    private void queue()
    {
        //带阻塞队列
        LinkedBlockingQueue<Runnable> runnables = new LinkedBlockingQueue<>();
    }

    private Runnable runnable = new Runnable()
    {
        @Override
        public void run()
        {
            while (true)
            {

            }
        }
    };

    /**
     * 线程池管理，管理整个项目中的所有线程
     * Created by Administrator on 2018/2/8.
     */

    public static class ThreadPoolManager {
        private static ThreadPoolManager mIntance;
        private int corePoolSize;//核心线程池的数量，同时能够执行的线程数量
        private int maximumPoolSize;//最大线程池数量，表示当缓冲队列满的时候能继续容纳的等待任务的数量
        private long keepAliveTime = 1;//存活时间
        private TimeUnit unit = TimeUnit.HOURS;//小时
        private ThreadPoolExecutor executor;
        public static ThreadPoolManager getInstance(){
            if(mIntance == null){
                mIntance = new ThreadPoolManager();
            }
            return mIntance;
        }

        private ThreadPoolManager() {
            //corePoolSize赋值：当前设备可用处理器核心数*2 + 1
            corePoolSize = Runtime.getRuntime().availableProcessors()*2+1;
            maximumPoolSize = corePoolSize; //最大线程池数量数量与核心数设置为一致
            executor = new ThreadPoolExecutor(
                    corePoolSize, //当某个核心任务执行完毕，会依次从缓冲队列中取出等待任务
                    maximumPoolSize, //先corePoolSize,然后new LinkedBlockingQueue<Runnable>(),然后maximumPoolSize,但是它的数量是包含了corePoolSize的
                    keepAliveTime, //表示的是maximumPoolSize当中等待任务的存活时间
                    unit,
                    new LinkedBlockingQueue<Runnable>(), //缓冲队列，用于存放等待任务，Linked的先进先出
                    Executors.defaultThreadFactory(), //创建线程的工厂，默认
                    new ThreadPoolExecutor.AbortPolicy() //用来对超出maximumPoolSize的任务的处理策略
            );
        }

        /**
         * 执行任务
         */
        public void execute(Runnable runnable){
            if(runnable==null){
                return;
            }
            executor.execute(runnable);
        }
        /**
         * 从线程池中移除任务
         */
        public void remove(Runnable runnable){
            if(runnable==null){
                return;
            }
            executor.remove(runnable);
        }
    }
}
