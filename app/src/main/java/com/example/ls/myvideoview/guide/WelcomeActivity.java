package com.example.ls.myvideoview.guide;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.ls.myvideoview.Main2Activity;
import com.example.ls.myvideoview.MainActivity;
import com.example.ls.myvideoview.R;
import com.example.ls.myvideoview.util.SharedPreferencesUtil;

import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity {

    //    @Bind(R.id.iv_entry)
//    ImageView mIVEntry;
    private MyCountDownTimer mc;
    private TextView tv;
    private Handler handler = new Handler();
    private static final int ANIM_TIME = 2000;

    private static final float SCALE_END = 1.15F;

//    private static final int[] Imgs={
//            R.drawable.welcomimg1,R.drawable.welcomimg2,
//            R.drawable.welcomimg3,R.drawable.welcomimg4,
//            R.drawable.welcomimg5, R.drawable.welcomimg6,
//            R.drawable.welcomimg7,R.drawable.welcomimg8,
//            R.drawable.welcomimg9,R.drawable.welcomimg10,
//            R.drawable.welcomimg11,R.drawable.welcomimg12};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        // 判断是否是第一次开启应用
        boolean isFirstOpen = SharedPreferencesUtil.getBoolean(this, SharedPreferencesUtil.FIRST_OPEN, true);
        // 如果是第一次启动，则先进入功能引导页
        if (isFirstOpen) {
            Intent intent = new Intent(this, MainActivity.class);

//            Intent intent = new Intent(this, WelcomeGuideActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        // 如果不是第一次启动app，则正常显示启动屏
        ButterKnife.bind(this);
//        startMainActivity();
        tv = (TextView) findViewById(R.id.tv_skipGo);
        mc = new MyCountDownTimer(3000, 1000);
        mc.start();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {


                Intent intent = new Intent(WelcomeActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    /**
     * 实现倒计时
     */
    class MyCountDownTimer extends CountDownTimer {
        /**
         * @param millisInFuture    表示以毫秒为单位 倒计时的总数
         * @param countDownInterval 表示 间隔 多少微秒 调用一次 onTick 方法
         */
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        public void onFinish() {
            tv.setText("正在跳转");
        }

        public void onTick(long millisUntilFinished) {
            tv.setText(millisUntilFinished / 1000 + "");
        }

    }
//    private void startMainActivity(){
//        Random random = new Random(SystemClock.elapsedRealtime());//SystemClock.elapsedRealtime() 从开机到现在的毫秒数（手机睡眠(sleep)的时间也包括在内）
//        mIVEntry.setImageResource(Imgs[random.nextInt(Imgs.length)]);
//
//        Observable.timer(1000, TimeUnit.MILLISECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Long>()
//                {
//
//                    @Override
//                    public void call(Long aLong)
//                    {
//                        startAnim();
//                    }
//                });
//    }
//
//    private void startAnim() {
//
//        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mIVEntry, "scaleX", 1f, SCALE_END);
//        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mIVEntry, "scaleY", 1f, SCALE_END);
//
//        AnimatorSet set = new AnimatorSet();
//        set.setDuration(ANIM_TIME).play(animatorX).with(animatorY);
//        set.start();
//
//        set.addListener(new AnimatorListenerAdapter()
//        {
//
//            @Override
//            public void onAnimationEnd(Animator animation)
//            {
//
//                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
//                WelcomeActivity.this.finish();
//            }
//        });
//    }
//
//    /**
//     * 屏蔽物理返回按钮
//     * @param keyCode
//     * @param event
//     * @return
//     */
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(keyCode==KeyEvent.KEYCODE_BACK){
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}
