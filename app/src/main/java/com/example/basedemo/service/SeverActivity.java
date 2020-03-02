package com.example.basedemo.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.basedemo.R;

public class SeverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sever);
        Intent intent  = new Intent();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            this.startForegroundService();
        }else {
//            this.startService();
        }

    }
}
