package com.example.basedemo.net;

import android.app.job.JobParameters;
import android.os.Build;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class JobService extends android.app.job.JobService
{
    /**
     * 在主线程中执行， 而往往耗时操作需要在子线程中执行
     *
     * @param jobParameters
     * @return
     */
    @Override
    public boolean onStartJob(JobParameters jobParameters)
    {
        //是否重新 执行 否
        jobFinished(jobParameters, false);
        return false;
    }

    /**
     * @param jobParameters
     * @return
     */
    @Override
    public boolean onStopJob(JobParameters jobParameters)
    {
        return false;
    }
}
