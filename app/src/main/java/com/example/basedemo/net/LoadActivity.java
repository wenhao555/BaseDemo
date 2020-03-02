package com.example.basedemo.net;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.basedemo.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class LoadActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
    }

    private void imgLoad()
    {
        this.getApplicationContext();
        Picasso.with(this).load("www.baidu.com").into(new Target()
        {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from)
            {//当图片完成后 可以进行File文件缓存

            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable)
            {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable)
            {

            }
        });
    }
}
