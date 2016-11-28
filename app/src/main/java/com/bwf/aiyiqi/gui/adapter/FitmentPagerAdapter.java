package com.bwf.aiyiqi.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseFragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */

public class FitmentPagerAdapter extends MyBaseFragmentPagerAdapter{
    String [] tab;
    public FitmentPagerAdapter(FragmentManager fm, List<Fragment> list,String [] tab) {
        super(fm, list);
        super.list=list;
        this.tab=tab;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tab[position];
    }
}
