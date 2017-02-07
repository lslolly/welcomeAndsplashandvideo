package com.example.ls.myvideoview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ls.myvideoview.adapter.AllGameAdapter;
import com.example.ls.myvideoview.adapter.HeaderRecyclerAndFooterWrapperAdapter;
import com.example.ls.myvideoview.bean.AllGameBean;
import com.example.ls.myvideoview.util.ViewHolder;
import com.mcxtzhang.indexlib.IndexBar.widget.IndexBar;
import com.mcxtzhang.indexlib.suspension.SuspensionDecoration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private static final String TAG = "ls";
    private RecyclerView mRv;
    private AllGameAdapter mAdapter;
    private HeaderRecyclerAndFooterWrapperAdapter mHeaderAdapter;
    private LinearLayoutManager mManager;
    private List<AllGameBean> mDatas;//元数据
    private Button mCommitButton;
    private SuspensionDecoration mDecoration;
    private List<AllGameBean> selectDatas;//选择的数据

    private List<Integer> bgIDList;//背景图片id

    /**
     * 右侧边栏导航区域
     */
    private IndexBar mIndexBar;

    /**
     * 显示指示器DialogText
     */
    private TextView mTvSideBarHint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Log.d("ls","11111111111111111111==");
        mRv = (RecyclerView) findViewById(R.id.rv);

        mCommitButton = (Button) findViewById(R.id.btn_commit);// 确定按钮

        selectDatas = new LinkedList<>();
        bgIDList = new LinkedList<>();
        bgIDList.add(AllGameBean.TYPE_1);

        mRv.setLayoutManager(mManager = new LinearLayoutManager(this));
        mAdapter = new AllGameAdapter(this, mDatas);
        mAdapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (int) view.getTag();
                Toast.makeText(getBaseContext(), "点击，当前位置=" + position, Toast.LENGTH_SHORT).show();

                AllGameBean allGameBean = mDatas.get(position);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.item_root);
                TextView tv = (TextView) linearLayout.findViewById(R.id.tv_bg);

                if (mDatas.get(position).getBgID() == AllGameBean.TYPE_0) {
                    switch (selectDatas.size()) {
                        case 0:
                            allGameBean.setBgID(bgIDList.get(0));
                            tv.setBackgroundResource(bgIDList.get(0));
                            selectDatas.add(allGameBean);
                            bgIDList.remove(0);
                            break;
                        case 1:
                            allGameBean.setBgID(bgIDList.get(0));
                            tv.setBackgroundResource(bgIDList.get(0));
                            selectDatas.add(allGameBean);
                            bgIDList.remove(0);
                            break;
                        case 2:
                            allGameBean.setBgID(bgIDList.get(0));
                            tv.setBackgroundResource(bgIDList.get(0));
                            selectDatas.add(allGameBean);
                            bgIDList.remove(0);
                            break;
                        case 3:
                            allGameBean.setBgID(bgIDList.get(0));
                            tv.setBackgroundResource(bgIDList.get(0));
                            selectDatas.add(allGameBean);
                            bgIDList.remove(0);
                            break;
                        case 4:
                            allGameBean.setBgID(bgIDList.get(0));
                            tv.setBackgroundResource(bgIDList.get(0));
                            selectDatas.add(allGameBean);
                            bgIDList.remove(0);
                            break;
                        case 5:
                            Toast.makeText(getBaseContext(), "最多选择5个", Toast.LENGTH_SHORT).show();
                            break;

                    }
                } else {
                    selectDatas.remove(allGameBean);
                    bgIDList.add(allGameBean.getBgID());
                    allGameBean.setBgID(AllGameBean.TYPE_0);
                    linearLayout.setBackgroundResource(AllGameBean.TYPE_0);
                }
            }
        });

        mHeaderAdapter = new HeaderRecyclerAndFooterWrapperAdapter(mAdapter) {
            @Override
            protected void onBindHeaderHolder(ViewHolder holder, int headerPos, int layoutId, Object o) {
                holder.setText(R.id.tvCity, (String) o);
            }
        };
//        mHeaderAdapter = new HeaderRecyclerAndFooterWrapperAdapter(mAdapter) {
//            @Override
//            protected void onBindHeaderHolder(ViewHolder holder, int headerPos, int layoutId, Object o) {
//                holder.setText(R.id.tvCity, (String) o);
//            }
//        };
//        mHeaderAdapter.setHeaderView(R.layout.item_city, "test");
//
        mRv.setAdapter(mHeaderAdapter);
        mRv.addItemDecoration(mDecoration = new SuspensionDecoration(this, mDatas).setHeaderViewCount(mHeaderAdapter.getHeaderViewCount()));

        //如果add两个，那么按照先后顺序，依次渲染。
//        mRv.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL_LIST));

        //使用indexBar
        mTvSideBarHint = (TextView) findViewById(R.id.tvSideBarHint);//HintTextView
        mIndexBar = (IndexBar) findViewById(R.id.indexBar);//IndexBar

        mIndexBar.setmPressedShowTextView(mTvSideBarHint)//设置HintTextView
                .setNeedRealIndex(true)//设置需要真实的索引
                .setmLayoutManager(mManager);//设置RecyclerView的LayoutManager

        initDatas(getResources().getStringArray(R.array.provinces));


    }

    /**
     * 组织数据源
     *
     * @param data
     * @return
     */
    private void initDatas(final String[] data) {
        mDatas = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            AllGameBean allGameBean = new AllGameBean();
            allGameBean.setCity(data[i]);//设置城市名称
            mDatas.add(allGameBean);
        }

        mIndexBar.setmSourceDatas(mDatas)//设置数据
                .setHeaderViewCount(mHeaderAdapter.getHeaderViewCount())//设置HeaderView数量
                .invalidate();

        mAdapter.setDatas(mDatas);
        mHeaderAdapter.notifyDataSetChanged();
        mDecoration.setmDatas(mDatas);
    }

    /**
     * 更新数据源
     *
     * @param view
     */
    public void updateDatas(View view) {
        for (int i = 0; i < 15500; i++) {
            mDatas.add(new AllGameBean("花千骨"));
            mDatas.add(new AllGameBean("王者荣耀"));
        }
        mIndexBar.setmSourceDatas(mDatas)
                .invalidate();
        mHeaderAdapter.notifyDataSetChanged();
    }

}
