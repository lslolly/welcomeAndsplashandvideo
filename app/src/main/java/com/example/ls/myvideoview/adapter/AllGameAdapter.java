package com.example.ls.myvideoview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ls.myvideoview.R;
import com.example.ls.myvideoview.bean.AllGameBean;

import java.util.List;


public class AllGameAdapter extends RecyclerView.Adapter<AllGameAdapter.ViewHolder>{
    protected Context mContext;
    protected List<AllGameBean> mDatas;
    protected LayoutInflater mInflater;
    private AllGameBean allGameBean;

    public AllGameAdapter(Context mContext, List<AllGameBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(mContext);

    }

    public List<AllGameBean> getDatas() {
        return mDatas;
    }

    public AllGameAdapter setDatas(List<AllGameBean> datas) {
        mDatas = datas;
        return this;
    }

    @Override
    public AllGameAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city, parent, false);
        ViewHolder vh = new ViewHolder(view);
//        将创建的View注册点击事件
//        view.setOnClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(final AllGameAdapter.ViewHolder holder, final int position) {
        //获取数据
        final AllGameBean allGameBean = mDatas.get(position);
        holder.tvCity.setText(allGameBean.getCity());
        holder.avatar.setImageResource(R.drawable.gfan_floatview_icon);
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCity, tvBg;
        ImageView avatar;
        private LinearLayout rootView;

        public ViewHolder(View itemView) {
            super(itemView);
            rootView = (LinearLayout) itemView.findViewById(R.id.item_root);
            tvBg = (TextView) itemView.findViewById(R.id.tv_bg);
            tvCity = (TextView) itemView.findViewById(R.id.tvCity);
            avatar = (ImageView) itemView.findViewById(R.id.ivAvatar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                    Toast.makeText(mContext,"当前点击"+getPosition(),Toast.LENGTH_LONG).show();
                    Log.d("ls","mOnClicklistener=="+mOnClicklistener);
                    if (mOnClicklistener != null) {
//                        Log.d("ls",mOnClicklistener);
                        mOnClicklistener.onClick(v);
                    }
                }
            });
        }


    }

    private View.OnClickListener mOnClicklistener;

    public void setListener(View.OnClickListener clickListener) {
        Log.d("ls","clickListener=="+clickListener);
        mOnClicklistener = clickListener;
    }
}
