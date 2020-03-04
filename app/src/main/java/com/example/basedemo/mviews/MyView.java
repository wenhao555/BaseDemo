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
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

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
            canvas.save();//保存当前canvas的状态，save之后 可以调用Canvas的平移、方缩 、 旋转、 错切 、 剪裁等操作
            if (i < 5)
            {
                canvas.clipRect(i * 20, 0, (i + 1) * 20, imgs[i].getHeight());//裁剪出一块显示出来的矩形区域
            } else
            {
                canvas.clipRect(i * 20, 0, i * 20 + imgs[i].getWidth(), imgs[i].getHeight());
            }
            canvas.drawBitmap(imgs[i], i * 20, 0, paint);
            canvas.restore();//用来恢复Canvas之前保存的状态，放置save后对Canvas执行的操作对后续的绘制影响
        }
    }
}
