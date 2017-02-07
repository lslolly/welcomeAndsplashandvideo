package com.example.ls.myvideoview.bean;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${lishu} on 2017/1/10.
 */

public class AllGameAdapter22 extends RecyclerView.Adapter<AllGameAdapter22.AllGameBeanViewHolder> {
    private Context mContext;
    //    private List<AllGameBean> selectBeans;
    private List<AllGameBean> allGameBeen;

//    private AllGameItem.Listener listener;
//private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public AllGameAdapter22(Context context) {
        this.mContext = context;
        allGameBeen = new ArrayList<>();
//        selectBeans = new LinkedList<>();
    }

    public List<AllGameBean> getData() {
        return allGameBeen;
    }

//    public void setListener(AllGameItem.Listener listener) {
//        this.listener = listener;
//    }

    public void updateData(List<AllGameBean> cBeens) {
        allGameBeen.clear();
        allGameBeen.addAll(cBeens);
        notifyDataSetChanged();
    }

    @Override
    public AllGameBeanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AllGameItem itemView = new AllGameItem(mContext);
//        itemView.setListener(listener);
        return new AllGameBeanViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AllGameAdapter22.AllGameBeanViewHolder holder, int position) {
        AllGameItem itemView = (AllGameItem) holder.itemView;
        itemView.setTag(position);
//        holder.checkBox.setTag(position);
        itemView.setData(allGameBeen.get(position));
    }

    @Override
    public int getItemCount() {
        return allGameBeen == null ? 0 : allGameBeen.size();

    }

//    public List<AllGameBean> getSelectBeans() {
//        return selectBeans;
//    }

    //    @Override
//    public void onClick(View view) {
//        if (mOnItemClickListener != null) {
//            //注意这里使用getTag方法获取数据
//            mOnItemClickListener.onItemClick(view,(String)view.getTag());
//        }
//    }
    class AllGameBeanViewHolder extends RecyclerView.ViewHolder {

        CheckBox checkBox;

        public AllGameBeanViewHolder(View itemView) {
            super(itemView);
//           checkBox = (CheckBox) itemView.findViewById(R.id.check_box);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnClicklistener != null) {
                        mOnClicklistener.onClick(v);
                    }

                }
            });

        }
    }


    //    //define interface
//    public static interface OnRecyclerViewItemClickListener {
//        void onItemClick(View view , String data);
//    }
    private View.OnClickListener mOnClicklistener;

    public void setListener(View.OnClickListener clickListener) {
        mOnClicklistener = clickListener;
    }

}
