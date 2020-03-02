package com.example.basedemo.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class JavaReference
{
    public static void main(String[] args)
    {
        weakReference();
//        softReference();
    }

    /**
     * 弱引用
     * 内存不够时回进行对象回收
     */
    private static void softReference()
    {
        Object object = new Object();
        SoftReference<Object> softReference = new SoftReference<>(object);
        Object as = softReference.get();
        System.gc();
        if (as != null)
        {
            System.out.println("未清楚");
        } else
        {
            System.out.println("清楚");
        }
    }

    /**
     * 软引用
     * 不管内存是否充足 ，都会被回收
     * 一般在处理图片的时候
     */
    private static void weakReference()
    {
        Object object = null;
        object = new Object();
        WeakReference<Object> softReference = new WeakReference<>(object);
        Object as = softReference.get();
        System.gc();
        if (object != null)
        {
            System.out.println("未清楚");
        } else
        {
            System.out.println("清楚");
        }
    }

    private static ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<byte[]>();
    private static int _1M = 1024 * 1024;

    private static <k> void referenceQueue()
    {
        Object object = new Object();
        Map<Object, Object> map = new HashMap<>();
        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                int cnt = 0;
                WeakReference<byte[]> k = null;
                while(true)
                {
                    try
                    {
                        if (!((k=(WeakReference)referenceQueue.remove())!=null)) break;
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    System.out.println((cnt++) + "回收了:" + k);
                }
            }


        };
    }
}
