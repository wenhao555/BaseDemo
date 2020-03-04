package com.example.basedemo.arouter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.basedemo.R;
import com.example.basedemo.jetpac.User;

@Route(path = "/app/arouter/LoginnActivity")
public class LoginnActivity extends AppCompatActivity
{
    @Autowired(name = "str")
    String name;
    @Autowired(name = "user")
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginn);
        Log.e("测试传递", name + "user:" + user);

    }
}
