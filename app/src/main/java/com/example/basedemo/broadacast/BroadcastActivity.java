package com.example.basedemo.broadacast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.example.basedemo.BaseActivity;
import com.example.basedemo.R;

import java.net.NetworkInterface;

public class BroadcastActivity extends BaseActivity {
    private String tag = getClass().getName();
    private IntentFilter intentFilter;
    private NetWorkChangeReceiver receiver;

    @Override
    public int getLayoutId() {
        return R.layout.activity_broadcast;
    }

    @Override
    public void initData() {
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        receiver = new NetWorkChangeReceiver();
//        registerReceiver(receiver, intentFilter);
    }

    @Override
    public void initView() {

    }

    private class NetWorkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            //系统服务类
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if (networkInfo != null && networkInfo.isAvailable()) {
                showToast("网络连接正常");
            } else {
                showToast("网络连接失败");
            }

        }
    }

    private void showToast(String str){
        Toast.makeText(mInstance, str, Toast.LENGTH_SHORT).show();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void dis() {
        Log.e(tag, "dis");
    }

}
