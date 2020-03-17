package com.example.basedemo.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.basedemo.R;

public class Anim_A_Activity<T> extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim__a_);
        startActivity(new Intent(this, Anim_B_Activity.class));
    }

    private <T extends Object> void as()
    {

    }

}
