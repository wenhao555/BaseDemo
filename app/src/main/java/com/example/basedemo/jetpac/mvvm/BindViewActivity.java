package com.example.basedemo.jetpac.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.basedemo.R;
import com.example.basedemo.jetpac.User;
import com.example.basedemo.model.Account;
import com.example.baserdemo.mvvm.BindCc;

public class BindViewActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        BindCc binding = DataBindingUtil.setContentView(this, R.layout.activity_bind_view);
//        ActivityBindViewBinding binding = ActivityBindViewBinding.inflate(getLayoutInflater());
        User account = new User("wenhao", 1);
        binding.setUser(account);
        User user = new User();
        user.nameOb.set("张三");
        binding.setLifecycleOwner(this);

    }
}
