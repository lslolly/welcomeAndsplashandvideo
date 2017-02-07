package com.example.ls.myvideoview.guide;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ls.myvideoview.R;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {



    private ViewPager viewPager;

    private ViewPagerAdapter vpAdapter;

    private ArrayList<View> views;

    private static final int[] pics = {R.drawable.guide1, R.drawable.guide2,R.drawable.guide3,R.drawable.guide4};

    private ImageView[] points;

    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide2);

        initView();

        initData();
    }

    /**
     *初始化视图
     */
    private void initView(){
        views = new ArrayList<View>();

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        vpAdapter = new ViewPagerAdapter(views);
    }

    /**
     * 初始化数据
     */
    private void initData(){
        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT);

        for(int i=0; i<pics.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(mParams);
            iv.setImageResource(pics[i]);
            views.add(iv);
        }

        viewPager.setAdapter(vpAdapter);
        viewPager.setOnPageChangeListener(this);

        initPoint();
    }


    private void initPoint(){
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll);

        points = new ImageView[pics.length];

        for (int i = 0; i < pics.length; i++) {
            points[i] = (ImageView) linearLayout.getChildAt(i);
            points[i].setEnabled(true);
            points[i].setOnClickListener(this);
            points[i].setTag(i);
        }

        currentIndex = 0;
        points[currentIndex].setEnabled(false);
    }


    @Override
    public void onPageScrollStateChanged(int arg0) {

    }


    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }



    @Override
    public void onPageSelected(int position) {
        setCurDot(position);
    }


    @Override
    public void onClick(View v) {
        int position = (Integer)v.getTag();
        setCurView(position);
        setCurDot(position);
    }

    private void setCurView(int position){
        if (position < 0 || position >= pics.length) {
            return;
        }
        viewPager.setCurrentItem(position);
    }


    private void setCurDot(int positon){
        if (positon < 0 || positon > pics.length - 1 || currentIndex == positon) {
            return;
        }
        points[positon].setEnabled(false);
        points[currentIndex].setEnabled(true);

        currentIndex = positon;
    }
    class ViewPagerAdapter extends PagerAdapter {

        private ArrayList<View> views;

        public ViewPagerAdapter (ArrayList<View> views){
            this.views = views;
        }


        @Override
        public int getCount() {
            if (views != null) {
                return views.size();
            }
            return 0;
        }


        @Override
        public Object instantiateItem(View view, int position) {

            ((ViewPager) view).addView(views.get(position), 0);

            return views.get(position);
        }


        @Override
        public boolean isViewFromObject(View view, Object arg1) {
            return (view == arg1);
        }


        @Override
        public void destroyItem(View view, int position, Object arg2) {
            ((ViewPager) view).removeView(views.get(position));
        }
    }

    private long startTime = 0;
    private long endTime = 0;
    private int count = 0;
    private long total;

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        count++;
        if(count == 1){
            startTime = System.currentTimeMillis();
            Toast.makeText(this, "请再按一次退出!", Toast.LENGTH_SHORT).show();
            Log.i("TAG", String.valueOf(startTime));
        }else if(count == 2){
            endTime = System.currentTimeMillis();
            Log.i("TAG", String.valueOf(endTime));
            total = endTime - startTime;
            Log.i("TAG", String.valueOf(total));
            if(total < 2000){
                super.onBackPressed();//调用父类的此方法，相当于调用了finish()方法
            }else{
                count = 0;
                startTime = 0;
                endTime = 0;
                total = 0;
            }
        }
    }


}
