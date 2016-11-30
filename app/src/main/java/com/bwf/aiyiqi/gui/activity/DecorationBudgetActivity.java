package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.adapter.DecorationBudgetAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/30.
 */

public class DecorationBudgetActivity extends BaseActivity {
    @BindView(R.id.decoratebudget_backimage)
    ImageView decoratebudgetBackimage;
    @BindView(R.id.decoratebudget_tablayout)
    TabLayout decoratebudgetTablayout;
    @BindView(R.id.decoratebudget_viewpager)
    ViewPager decoratebudgetViewpager;
    private DecorationBudgetAdapter mAdaper;

    @Override
    protected int getViewResId() {
        return R.layout.decoration_budget;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        decoratebudgetTablayout.setupWithViewPager(decoratebudgetViewpager);
        mAdaper = new DecorationBudgetAdapter(getSupportFragmentManager());
        decoratebudgetViewpager.setAdapter(mAdaper);
        decoratebudgetBackimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
