package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    @BindView(R.id.tv_login_by_message)
    TextView tvLoginByMessage;
    @BindView(R.id.btn_act_login_common_forget)
    TextView btnActLoginCommonForget;

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

    @OnClick({R.id.tv_login_by_message, R.id.btn_act_login_common_forget})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.tv_login_by_message:
                intent = new Intent(LoginAndRegistActivity.this, LoginByMesActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_act_login_common_forget:
                intent = new Intent(LoginAndRegistActivity.this, ResetPwdActivity.class);
                startActivity(intent);
                break;
        }
    }
}
