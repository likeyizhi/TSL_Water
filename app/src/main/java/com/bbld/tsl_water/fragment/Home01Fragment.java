package com.bbld.tsl_water.fragment;

import com.bbld.tsl_water.R;
import com.bbld.tsl_water.base.BaseLazyFragment;

/**
 * 首页
 * Created by likey on 2017/8/23.
 */

public class Home01Fragment extends BaseLazyFragment{

    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void onUserVisible() {
        showToast("01");
    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_home01;
    }

    @Override
    protected void initViewsAndEvents() {

    }
}
