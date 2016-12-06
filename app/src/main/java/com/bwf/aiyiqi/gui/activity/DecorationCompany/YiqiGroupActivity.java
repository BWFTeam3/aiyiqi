package com.bwf.aiyiqi.gui.activity.DecorationCompany;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.adapter.YiqiGroupFragmentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/24.
 */

public class YiqiGroupActivity extends BaseActivity {
    @BindView(R.id.textView_title)
    TextView textViewTitle;
    @BindView(R.id.tabLayout_yiqigroup)
    TabLayout tabLayoutYiqigroup;
    @BindView(R.id.viewPager_yiqigroup)
    ViewPager viewPagerYiqigroup;
    private YiqiGroupFragmentPagerAdapter adapter;
    @Override
    protected int getViewResId() {
        return R.layout.subview_yiqigroup;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        textViewTitle.setText("一起团队");
        adapter = new YiqiGroupFragmentPagerAdapter(getSupportFragmentManager());
        tabLayoutYiqigroup.setupWithViewPager(viewPagerYiqigroup);
        viewPagerYiqigroup.setAdapter(adapter);
        viewPagerYiqigroup.setOffscreenPageLimit(3);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @OnClick(R.id.imageView_title)
    public void onClick() {
        finish();
    }
}
