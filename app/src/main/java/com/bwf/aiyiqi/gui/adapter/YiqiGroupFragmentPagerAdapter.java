package com.bwf.aiyiqi.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwf.aiyiqi.gui.fragment.YiqiGroupFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */

public class YiqiGroupFragmentPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments;
    String[] title = new String[]{"设计师","监理","工长"};
    private final String STYLIST = "1701";//设计师
    private final String SUPERVISOR = "1702";//监理
    private final String FOREMAN = "1703"; //工长
    public YiqiGroupFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        YiqiGroupFragment fragmentStylist = YiqiGroupFragment.newInstance(STYLIST);
        YiqiGroupFragment fragmentSupervisor = YiqiGroupFragment.newInstance(SUPERVISOR);
        YiqiGroupFragment fragmentForeman = YiqiGroupFragment.newInstance(FOREMAN);
        fragments.add(fragmentStylist);
        fragments.add(fragmentSupervisor);
        fragments.add(fragmentForeman);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
