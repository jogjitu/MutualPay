package com.catchblocker.mutualpay;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.catchblocker.mutualpay.util.SystemUiHider;


public class StartUpActivity extends Activity {
    private static int SPLASH_TIME_OUT=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(StartUpActivity.this,UserProfile.class);
                StartUpActivity.this.startActivity(intent);
                StartUpActivity.this.finish();
            }
        },SPLASH_TIME_OUT);
    }

}
