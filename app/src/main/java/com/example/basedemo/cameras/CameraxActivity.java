package com.example.basedemo.cameras;

import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraX;
import androidx.camera.core.Preview;
import androidx.camera.core.PreviewConfig;

import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Rational;
import android.util.Size;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;

import com.example.basedemo.R;

public class CameraxActivity extends AppCompatActivity
{
    private TextureView finder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camerax);
        finder = findViewById(R.id.finder);
        finder.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
        {//布局变化监听
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom)
            {
                updateTransform();
            }
        });
        finder.post(new Runnable()
        {
            @Override
            public void run()
            {
                startCamera();
            }
        });

    }

    private void updateTransform()
    {
        Matrix matrix = new Matrix();
        // Compute the center of the view finder
        float centerX = finder.getWidth() / 2f;
        float centerY = finder.getHeight() / 2f;

        float[] rotations = {0, 90, 180, 270};
        // Correct preview output to account for display rotation
        float rotationDegrees = rotations[finder.getDisplay().getRotation()];

        matrix.postRotate(-rotationDegrees, centerX, centerY);

        // Finally, apply transformations to our TextureView
        finder.setTransform(matrix);
    }

    private void startCamera()
    {
        // 1. preview
        PreviewConfig previewConfig = new PreviewConfig.Builder()
                .setTargetAspectRatio(new Rational(1, 1))
                .setTargetResolution(new Size(640, 640))
                .build();

        Preview preview = new Preview(previewConfig);
        preview.setOnPreviewOutputUpdateListener(new Preview.OnPreviewOutputUpdateListener()
        {
            @Override
            public void onUpdated(Preview.PreviewOutput output)
            {
                ViewGroup parent = (ViewGroup) finder.getParent();
                parent.removeView(finder);
                parent.addView(finder, 0);

                finder.setSurfaceTexture(output.getSurfaceTexture());
                updateTransform();
            }
        });

        CameraX.bindToLifecycle(this, preview);

    }
}
