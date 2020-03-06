package com.example.basedemo.mviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class ViewGroupEvent extends ViewGroup
{

    public ViewGroupEvent(Context context)
    {
        super(context);
    }

    public ViewGroupEvent(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public ViewGroupEvent(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 派遣触摸事件
     * 包含了具体事件分发逻辑
     * 返回结果收当前View的onTouchEvent方法和下级的该方法影响
     *
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event)
    {
        boolean cunsume = false;
/**
 *   onInterceptTouchEvent返回为true的时候则该事件交给当前ViewGroup处理
 *   否则会调用子元素的dispatchTouchEvent 把事件传递给子元素
 *   如果dispatchTouchEvent返回false则会返回给上层处理
 */

        if (onInterceptTouchEvent(event))
        {
//            cunsume = onTouchEvent();
        } else
        {
//            consume = child.dispatchTouchEvent(ev);
        }
        return cunsume;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b)
    {

    }


    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        return super.onTouchEvent(event);
    }

    @Override
    public void setOnTouchListener(OnTouchListener l)
    {
        super.setOnTouchListener(l);
    }
}
