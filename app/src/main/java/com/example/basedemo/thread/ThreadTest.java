package com.example.basedemo.thread;

public class ThreadTest
{
    private static volatile boolean stop = true; //走一次线程之后停止
//    private static boolean stop = false;// 线程直接不启动

    public static void main(String[] args)
    {
        stopThread();

    }

    private static void start()
    {

    }

    private static void stopThread()
    {

        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                int i = 0;
                while (true)
                {
                    if (Thread.currentThread().isInterrupted())
                    {
                        i++;
                        return;

                    }

                    System.out.println(i);
                }
            }
        };

        thread.start();
        System.out.println("线程开始");
        thread.interrupt();
//        stop = true;
    }
}
