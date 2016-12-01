package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/1.
 */

public class FitsideActivity extends BaseActivity {

    @Override
    protected int getViewResId() {
        return R.layout.activity_fitside1;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }
}
