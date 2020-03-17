package com.example.basedemo.recy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.basedemo.R;
import com.example.basedemo.model.Account;

import java.util.ArrayList;
import java.util.List;

public class RecyTestActivity extends AppCompatActivity
{
    private RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy_test);
        mRecycler = findViewById(R.id.mRecycler);
        //设置列表位置
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(manager);
        ((LinearLayoutManager) manager).setOrientation(OrientationHelper.VERTICAL);
        mRecycler.setItemAnimator(new DefaultItemAnimator());//默认的删除动画
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecycler.addItemDecoration(dividerItemDecoration);
        mRecycler.setHasFixedSize(true);
        List<Account> accounts = new ArrayList<>();
        Account account;
        for (int i = 0; i < 10; i++)
        {
            account = new Account();
            account.setAge(i);
            account.setName("姓名：" + i);
            accounts.add(account);
        }
        ManRecycleAdapter adapter = new ManRecycleAdapter(this, accounts);
        mRecycler.setAdapter(adapter);
    }
}
