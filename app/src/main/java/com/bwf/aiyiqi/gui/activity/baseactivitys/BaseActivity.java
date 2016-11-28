package com.bwf.aiyiqi.gui.activity.baseactivitys;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/11/23.
 */

public abstract class BaseActivity extends FragmentActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getViewResId());
        initViews();
        initDatas();
    }


    protected abstract int getViewResId();
    protected abstract void initViews();
    protected abstract void initDatas();
    public void setFullSreem(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

}
