package com.bwf.aiyiqi.gui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.adapter.ViewPagerAdapter;

import static com.bwf.aiyiqi.R.id.l3;

public class design_measureActivity extends BaseActivity {
    ViewPager viewPager;
    ViewPagerAdapter fragmentPagerAdapter;
    TabLayout tabLayout;
    LinearLayout linearLayout;

    @Override
    protected int getViewResId() {
        return R.layout.design_measure;
    }

    @Override
    protected void initViews() {
        tabLayout = (TabLayout) findViewById(R.id.Tablayout111);
        viewPager = (ViewPager) findViewById(R.id.ViewPager);
        linearLayout = (LinearLayout) findViewById(l3);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        fragmentPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void initDatas() {

    }

}
