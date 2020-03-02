package com.example.basedemo.net;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;

import com.example.basedemo.R;

public class taskNetActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_net);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        //定时操作
        jobScheduler();
    }

    private void jobScheduler()
    {
        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        @SuppressLint("JobSchedulerService")
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this, JobService.class));
        //设置builder
        builder.setPeriodic(3000);//每隔三秒钟
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_NONE);//设置网络格式
        builder.setRequiresCharging(true);//设置充电状态下触发
        jobScheduler.schedule(builder.build());

    }
}
