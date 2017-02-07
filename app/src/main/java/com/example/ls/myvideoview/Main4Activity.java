package com.example.ls.myvideoview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ls.myvideoview.bean.AllGameAdapter22;
import com.example.ls.myvideoview.bean.AllGameBean;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity {

    private RecyclerView pRecyclerView;
    private AllGameAdapter22 allGameAdapter22;
    private ArrayList<AllGameBean> seletedItems = new ArrayList<>();
    private List<AllGameBean> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        pRecyclerView = (RecyclerView) findViewById(R.id.rv);
        final LinearLayoutManager manager = new LinearLayoutManager(Main4Activity.this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        pRecyclerView.setLayoutManager(manager);
        allGameAdapter22 = new AllGameAdapter22(this);

        allGameAdapter22.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (int) view.getTag();
                AllGameBean bean = mDatas.get(position);
                seletedItems.add(bean);
                Log.d("ls","seleted=="+seletedItems);
                if (seletedItems.size() > 5) {
                    Toast.makeText(Main4Activity.this, "最多只能选择5个哦", Toast.LENGTH_LONG).show();
                } else {
                    seletedItems.remove(bean);
                }
            }
        });
        pRecyclerView.setAdapter(allGameAdapter22);
        loadPhotoData(getResources().getStringArray(R.array.provinces));
        allGameAdapter22.updateData(mDatas);

    }

    private void loadPhotoData(final String[] data) {
        mDatas = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            AllGameBean allGameBean = new AllGameBean();
            allGameBean.setCity(data[i]);//设置城市名称
            mDatas.add(allGameBean);
        }

    }

}
