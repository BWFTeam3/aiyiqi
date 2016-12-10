package com.bwf.aiyiqi.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.bwf.aiyiqi.gui.fragment.design;
import com.bwf.aiyiqi.gui.fragment.measure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 */

public class ViewPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    List<Fragment> list;
    List<String> StringList;
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        StringList = new ArrayList<>();
            StringList.add("免费设计");
            StringList.add("免费量房");
        list = new ArrayList<>();
            list.add(new design());
            list.add(new measure());

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
        return StringList.get(position);
    }
}
