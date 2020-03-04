package com.example.basedemo.mviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyViewGroup extends FrameLayout
{
    //声明对象时调用
    public MyViewGroup(@NonNull Context context)
    {
        super(context);
    }

    // XML中反射调用
    public MyViewGroup(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
    }

    //添加style时调用
    public MyViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    public MyViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    //测量子对象 和本对象大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //设置布局位置
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom)
    {
        super.onLayout(changed, left, top, right, bottom);
    }
}
