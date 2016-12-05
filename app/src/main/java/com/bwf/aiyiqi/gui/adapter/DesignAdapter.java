package com.bwf.aiyiqi.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseFragmentPagerAdapter;

import java.util.List;

/**
 * Created by Phyj on 2016/12/3.
 */

public class DesignAdapter extends MyBaseFragmentPagerAdapter {
    private List<Fragment> list;
    private String str[] = {"专题", "美图"};

    public DesignAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm, list);
        this.list = list;
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
        return str[position];
    }
}
