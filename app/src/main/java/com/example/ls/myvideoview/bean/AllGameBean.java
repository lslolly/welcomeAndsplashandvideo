package com.example.ls.myvideoview.bean;

import com.example.ls.myvideoview.R;
import com.mcxtzhang.indexlib.IndexBar.bean.BaseIndexPinyinBean;

/**
 * Created by zhangxutong .
 * Date: 16/08/28
 */

public class AllGameBean extends BaseIndexPinyinBean {
    public static int TYPE_0 = R.drawable.gl_login_ic_mm_b;
    public static int TYPE_1 = R.drawable.gl_login_ic_xmm_b;

    private String city;//城市名字
    private boolean isTop;//是否是最上面的 不需要被转化成拼音的
    private boolean isChecked;
    private String gameUrl;

    public int getBgID() {
        return bgID;
    }

    public void setBgID(int bgID) {
        this.bgID = bgID;
    }

    private int bgID = TYPE_0;

    public String getGameUrl() {
        return gameUrl;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }


    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public AllGameBean() {
    }

    public AllGameBean(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public AllGameBean setCity(String city) {
        this.city = city;
        return this;
    }

    public boolean isTop() {
        return isTop;
    }

    public AllGameBean setTop(boolean top) {
        isTop = top;
        return this;
    }

    @Override
    public String getTarget() {
        return city;
    }

    @Override
    public boolean isNeedToPinyin() {
        return !isTop;
    }


    @Override
    public boolean isShowSuspension() {
        return !isTop;
    }
}
