package com.example.basedemo.handler;


import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Mhandler
{
    private final Handler handler = new Handler(new Handler.Callback()
    {//需要弱引用
        @Override
        public boolean handleMessage(@NonNull Message message)
        {
//            更新UI
            return false;
        }
    });

    private void sendHanlder()
    {
        Message msg = handler.obtainMessage();
        msg.obj = "1";
        handler.sendMessage(msg);
    }

    // todu ***
    private void sendRxjava()
    {
        Observable.just("asd")//事件源
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())

                .subscribe(new Observer<String>()
                {
                    @Override
                    public void onComplete()
                    {
//将提前工作结束
                    }

                    @Override
                    public void onError(Throwable e)
                    {

                    }


                    @Override
                    public void onSubscribe(Disposable d)
                    {

                    }

                    @Override
                    public void onNext(String s)
                    {//处理完得到的结果更新UI

                    }
                });
    }
}
