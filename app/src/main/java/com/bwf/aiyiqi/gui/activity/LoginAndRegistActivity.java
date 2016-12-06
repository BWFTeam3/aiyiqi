package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 11645 on 2016/12/5.
 */

public class LoginAndRegistActivity extends BaseActivity {
    @BindView(R.id.header_left_textview)
    TextView headerLeftTextview;

    @Override
    protected int getViewResId() {
        return R.layout.activity_login_and_regist;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.header_left_textview)
    public void onClick() {
        finish();
    }
}
