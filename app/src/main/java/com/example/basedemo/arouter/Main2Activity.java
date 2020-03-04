package com.example.basedemo.arouter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.basedemo.BaseActivity;
import com.example.basedemo.R;
import com.example.basedemo.jetpac.User;

@Route(path = "/app/arouter/Main2Activity")
public class Main2Activity extends BaseActivity
{
    private User user;
    private String string = "123";

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
        ARouter.getInstance().build("/app/arouter/LoginnActivity")
                .withString("str", string)
//                .withTransition();//动画
                .withParcelable("user", new User("name", 12))
                .navigation();
    }
}
