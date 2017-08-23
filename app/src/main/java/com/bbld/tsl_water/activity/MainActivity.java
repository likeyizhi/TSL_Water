package com.bbld.tsl_water.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbld.tsl_water.R;
import com.bbld.tsl_water.base.BaseActivity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.tv10)
    TextView tv10;
    @BindView(R.id.tv20)
    TextView tv20;
    @BindView(R.id.tv30)
    TextView tv30;
    @BindView(R.id.tv40)
    TextView tv40;
    @BindView(R.id.tv50)
    TextView tv50;
    @BindView(R.id.tv60)
    TextView tv60;
    @BindView(R.id.tv70)
    TextView tv70;
    @BindView(R.id.tv80)
    TextView tv80;
    @BindView(R.id.tv90)
    TextView tv90;
    @BindView(R.id.tv100)
    TextView tv100;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.imgLeft)
    ImageView imgLeft;
    @BindView(R.id.imgRight)
    ImageView imgRight;
    @BindView(R.id.imgLeft02)
    ImageView imgLeft02;
    @BindView(R.id.imgRight02)
    ImageView imgRight02;

    private Timer timer;
    private boolean isOnTimer;
    private TimerTask timerTask;
    private int time = 60;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    changeColor();
                    break;
            }
        }
    };

    @Override
    protected void initViewsAndEvents() {
        Xiuxiu();
    }

    private void Xiuxiu() {
        timer = new Timer();
        isOnTimer = true;
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        time--;
                        handler.sendEmptyMessage(1);

//                        if (time < 0) {
//                            time = 6000;
//                            timer.cancel();
//                            isOnTimer = false;
//                        }
                    }
                });
            }
        };
        timer.schedule(timerTask, 0, 60);
    }

    private void changeColor() {
        tv10.setBackgroundColor(randomColor());
        tv20.setBackgroundColor(randomColor());
        tv30.setBackgroundColor(randomColor());
        tv40.setBackgroundColor(randomColor());
        tv50.setBackgroundColor(randomColor());
        tv60.setBackgroundColor(randomColor());
        tv70.setBackgroundColor(randomColor());
        tv80.setBackgroundColor(randomColor());
        tv90.setBackgroundColor(randomColor());
        tv100.setBackgroundColor(randomColor());
        if (imgLeft.getVisibility()==View.INVISIBLE && imgRight.getVisibility()==View.VISIBLE){
            imgLeft.setVisibility(View.VISIBLE);
            imgRight.setVisibility(View.INVISIBLE);
        }else if (imgLeft.getVisibility()==View.VISIBLE && imgRight.getVisibility()==View.INVISIBLE){
            imgLeft.setVisibility(View.INVISIBLE);
            imgRight.setVisibility(View.VISIBLE);
        }
        if (imgLeft02.getVisibility()==View.INVISIBLE && imgRight02.getVisibility()==View.VISIBLE){
            imgLeft02.setVisibility(View.VISIBLE);
            imgRight02.setVisibility(View.INVISIBLE);
        }else if (imgLeft02.getVisibility()==View.VISIBLE && imgRight02.getVisibility()==View.INVISIBLE){
            imgLeft02.setVisibility(View.INVISIBLE);
            imgRight02.setVisibility(View.VISIBLE);
        }
    }

    private int randomColor(){
        // 随机颜色
        Random random = new Random();
        int ranColor = 0xff000000 | random.nextInt(0x00ffffff);
        return ranColor;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }
}
