package com.example.basedemo.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;

import com.example.basedemo.R;
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
        Account account = new Account("wenhao", 1);
        binding.setAccount(account);
    }
}
