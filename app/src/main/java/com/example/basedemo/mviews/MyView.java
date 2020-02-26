package com.example.basedemo.mviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.example.basedemo.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyView extends FrameLayout
{
    public MyView(@NonNull Context context)
    {
        super(context);
        init();
    }

    public MyView(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public MyView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Paint paint;

    private void init()
    {
        for (int i = 0; i < 6; i++)
        {
            imgs[i] = BitmapFactory.decodeResource(getResources(), ids[i]);
        }
        paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿
    }

    private int[] ids = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private Bitmap[] imgs = new Bitmap[6];

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        //不能再里面进行new对象会出现内存消耗
        //相邻两张牌错开20个像素
        for (int i = 0; i < 6; i++)
        {
            /**
             * 设置图片员
             * 设置向右平移20个像素
             * 设置向上平移多少个像素
             */
            canvas.drawBitmap(imgs[i], i * 20, 0, paint);
        }
    }
}
