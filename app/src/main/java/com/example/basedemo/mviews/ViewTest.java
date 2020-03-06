package com.example.basedemo.mviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;


public class ViewTest extends View

{
    public ViewTest(Context context)
    {
        super(context);
    }

    public ViewTest(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
    }

    public ViewTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    /**
     * View 中的该方法如果有事件传递过来就会被调用
     * 该方法处理事件的逻辑顺序为onTouchListener-->onTouchEvent-->onClickListener。
     *
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event)
    {
        return super.dispatchTouchEvent(event);
    }

    /**
     * 如果设置了该方法   onTouch会被调用  如果OnTouch返回true则事件消耗结束不会被调用
     *
     * @param l
     */
    @Override
    public void setOnTouchListener(OnTouchListener l)
    {
        super.setOnTouchListener(l);
    }

    /**
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        return super.onTouchEvent(event);
    }

    private Paint paint;

    private void init()
    {
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        paint.reset();

    }
}
