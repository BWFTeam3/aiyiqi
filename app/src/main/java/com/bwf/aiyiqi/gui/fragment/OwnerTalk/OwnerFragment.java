package com.bwf.aiyiqi.gui.fragment.OwnerTalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.SearchActivity;
import com.bwf.aiyiqi.gui.adapter.OwnerTalkFragmentPagerAdapter;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/23.
 */

public class OwnerFragment extends BaseFragment {
    @BindView(R.id.tabLayout_ownerTalk)
    TabLayout tabLayoutOwnerTalk;
    @BindView(R.id.viewPager_ownerTalk)
    ViewPager viewPagerOwnerTalk;
    private List<Fragment> fragments;
    @Override
    protected int getViewResId() {
        return R.layout.owner_fragment;
    }

    @Override
    protected void initViews() {
        EliteFragment eliteFragment = new EliteFragment();
        NewestFragment newestFragment = new NewestFragment();
        SectionFragment sectionFragment = new SectionFragment();
        fragments = new ArrayList<>();
        fragments.add(eliteFragment);
        fragments.add(newestFragment);
        fragments.add(sectionFragment);
        OwnerTalkFragmentPagerAdapter adapter = new OwnerTalkFragmentPagerAdapter(getFragmentManager(),fragments);
        viewPagerOwnerTalk.setAdapter(adapter);
        tabLayoutOwnerTalk.setupWithViewPager(viewPagerOwnerTalk);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.iamgeView_ownerTalk)
    public void onClick() {
        startActivity(new Intent(getContext(), SearchActivity.class));
    }
}
