package com.bwf.aiyiqi.gui.activity;

import android.app.Dialog;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.TabBatchingData;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.adapter.TabLayoutAdapter;
import com.bwf.aiyiqi.gui.view.CustomMaterialRefreshLayout;
import com.bwf.aiyiqi.mvp.presenter.Impl.TabPresenterImpl;
import com.bwf.aiyiqi.mvp.presenter.TabPresenter;
import com.bwf.aiyiqi.mvp.view.ShowData;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import static com.bwf.aiyiqi.R.id.img;

/**
 * Created by Administrator on 2016/11/23.
 */

public class OderselfActivity extends BaseActivity implements ShowData,View.OnClickListener {
    TabPresenter tabPresenter;
    TabLayoutAdapter tabLayoutAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    RelativeLayout relativeLayout;
    ImageButton imageButton;
    CustomMaterialRefreshLayout customMaterialRefreshLayout;

    @Override
    protected int getViewResId() {
        return R.layout.order_self;
    }

    @Override
    protected void initViews() {
        imageButton = (ImageButton) findViewById(img);
        relativeLayout = (RelativeLayout) findViewById(R.id.Rela);
        viewPager = (ViewPager)findViewById(R.id.viewPager_under);
        tabLayout = (TabLayout)findViewById(R.id.tab_under);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tabPresenter = new TabPresenterImpl(this);
        tabPresenter.TabDataLoad();
        customMaterialRefreshLayout = (CustomMaterialRefreshLayout)findViewById(R.id.Custom);
        customMaterialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                tabPresenter.TabDataLoad();
            }
        });
        relativeLayout.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void showSuccess(TabBatchingData tabBatchingData) {
        customMaterialRefreshLayout.finishRefresh();
        tabLayoutAdapter = new TabLayoutAdapter(tabBatchingData, getSupportFragmentManager());
        viewPager.setAdapter(tabLayoutAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void showFalied() {
    }

    @Override
    public void onClick(View v) {
        Dialog dialog = new Dialog(this);
        Window window = dialog.getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.order_self_dialog);
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;//设置宽为铺满
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;//高 适应内容
        wl.x = 0;
        wl.y = this.getWindowManager().getDefaultDisplay().getHeight();
        dialog.show();
    }
}
