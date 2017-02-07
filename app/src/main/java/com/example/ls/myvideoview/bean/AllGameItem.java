package com.example.ls.myvideoview.bean;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ls.myvideoview.R;

/**
 * Created by ${lishu} on 2017/1/10.
 */

public class AllGameItem extends FrameLayout implements View.OnClickListener {

    private ImageView imageView;
    private CheckBox checkBox;
    private TextView textView;
    private AllGameBean allGameBean;
    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;

    }

    public AllGameItem(Context context) {
        this(context, null);
    }

    public AllGameItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.item_city, this);
        initView();
    }

    private void initView() {
//        checkBox = (CheckBox) findViewById(R.id.check_box);
        imageView = (ImageView) findViewById(R.id.ivAvatar);
        textView = (TextView) findViewById(R.id.tvCity);
//        checkBox.setOnClickListener(this);
//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                allGameBean.setChecked(b);
//            }
//        });
        this.setOnClickListener(this);



    }

    public void setData(AllGameBean allGameBean) {
        this.allGameBean = allGameBean;
        textView.setText(allGameBean.getCity());
        imageView.setImageResource(R.drawable.gfan_floatview_icon);

        if (allGameBean.isChecked()) {
//            checkBox.setChecked(true);
        } else {
//            checkBox.setChecked(false);
        }
    }

    @Override
    public void onClick(View view) {
//        checkBox.setChecked(checkBox.isChecked());
//        listener.onPhotoItemClick(view);
    }

    public interface Listener {
        void onPhotoItemClick(View v);
    }
}
