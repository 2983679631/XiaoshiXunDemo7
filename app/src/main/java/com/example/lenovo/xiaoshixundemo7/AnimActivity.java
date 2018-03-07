package com.example.lenovo.xiaoshixundemo7;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.lenovo.xiaoshixundemo7.v.MainActivity;

public class AnimActivity extends AppCompatActivity {

    private TextView tv_name;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        initView();
        initData();
    }

    private void initData() {

        handler.postAtTime(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(AnimActivity.this, MainActivity.class));

                finish();
            }
        },3000);

    }

    private void initView() {
        tv_name = (TextView) findViewById(R.id.tv_name);
    }
}
