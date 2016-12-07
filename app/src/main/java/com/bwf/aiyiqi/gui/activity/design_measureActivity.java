package com.bwf.aiyiqi.gui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.adapter.ViewPagerAdapter;

public class design_measureActivity extends BaseActivity {
    ViewPager viewPager;
    ViewPagerAdapter fragmentPagerAdapter;
    TabLayout tabLayout;
    ImageButton imageButton;

    @Override
    protected int getViewResId() {
        return R.layout.design_measure;
    }

    @Override
    protected void initViews() {
        imageButton = (ImageButton) findViewById(R.id.image111);
        tabLayout = (TabLayout) findViewById(R.id.Tablayout111);
        viewPager = (ViewPager) findViewById(R.id.ViewPager);
        imageButton.setOnClickListener(new View.OnClickListener() {
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
