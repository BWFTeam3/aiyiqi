package com.bwf.aiyiqi.gui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.adapter.DesignAdapter;
import com.bwf.aiyiqi.gui.fragment.DesignPsFragment;
import com.bwf.aiyiqi.gui.fragment.DesignTopicFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Phyj on 2016/12/3.
 */

public class DesignActivity extends BaseActivity {

    @BindView(R.id.design_imgbutton1)
    ImageButton designImgbutton1;
    @BindView(R.id.design_tablayout)
    TabLayout designTablayout;
    @BindView(R.id.design_viewpager)
    ViewPager designViewpager;
    private DesignAdapter designAdapter;
    private List<Fragment> fragments;

    @Override
    protected int getViewResId() {
        return R.layout.activity_design;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        fragments = new ArrayList<>();
        fragments.add(new DesignTopicFragment());
        fragments.add(new DesignPsFragment());
        designAdapter = new DesignAdapter(getSupportFragmentManager(), fragments);
        designTablayout.setupWithViewPager(designViewpager);
        designViewpager.setAdapter(designAdapter);
        designImgbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initDatas() {

    }

}
