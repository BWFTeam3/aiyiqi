package com.bwf.aiyiqi.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseFragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/4.
 */

public class OwnerTalkFragmentPagerAdapter extends MyBaseFragmentPagerAdapter {
    private String[] title = {"精华", "最新", "版块"};

    public OwnerTalkFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm, list);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
