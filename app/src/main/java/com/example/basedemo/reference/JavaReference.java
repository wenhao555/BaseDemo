package com.example.basedemo.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class JavaReference {
    public static void main(String[] args) {
        weakReference();
//        softReference();
    }

    /**
     * 弱引用
     * 内存不够时回进行对象回收
     */
    private static void softReference() {
        Object object = new Object();
        SoftReference<Object> softReference = new SoftReference<>(object);
        Object as = softReference.get();
        System.gc();
        if (as != null) {
            System.out.println("未清楚");
        } else {
            System.out.println("清楚");
        }
    }

    /**
     * 软引用
     * 不管内存是否充足 ，都会被回收
     * 一般在处理图片的时候
     */
    private static void weakReference() {
        Object object = null;
        object = new Object();
        WeakReference<Object> softReference = new WeakReference<>(object);
        Object as = softReference.get();
        System.gc();
        if (object != null) {
            System.out.println("未清楚");
        } else {
            System.out.println("清楚");
        }
    }
}
