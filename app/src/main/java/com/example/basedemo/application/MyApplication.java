package com.example.basedemo.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class MyApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        ARouter.init(this);
    }

    @Override
    public void onTerminate()
    {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }
}
