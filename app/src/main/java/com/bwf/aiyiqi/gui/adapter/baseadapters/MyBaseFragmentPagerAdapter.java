package com.bwf.aiyiqi.gui.adapter.baseadapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public abstract class MyBaseFragmentPagerAdapter extends FragmentPagerAdapter {
    protected List<Fragment> list;
    public MyBaseFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list=list;
    }
}