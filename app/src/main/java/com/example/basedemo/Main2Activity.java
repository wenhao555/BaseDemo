package com.example.basedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/app/Main2Activity")
public class Main2Activity extends BaseActivity
{

    private String string = "";

    @Override
    public int getLayoutId()
    {
        return R.layout.activity_main2;
    }

    @Override
    public void initData()
    {
    }

    @Override
    public void initView()
    {
    }

    public void check(View view)
    {
        ARouter.getInstance().build("/app/LoginnActivity").navigation();
    }
}
