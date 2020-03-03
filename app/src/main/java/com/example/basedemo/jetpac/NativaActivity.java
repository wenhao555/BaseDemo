package com.example.basedemo.jetpac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

import android.os.Bundle;

import com.example.basedemo.BaseActivity;
import com.example.basedemo.R;

public class NativaActivity extends BaseActivity
{


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void isStrt()
    {

    }

    @Override
    public int getLayoutId()
    {
        return R.layout.activity_nativa;
    }

    @Override
    public void initData()
    {

    }

    @Override
    public void initView()
    {

    }
}
