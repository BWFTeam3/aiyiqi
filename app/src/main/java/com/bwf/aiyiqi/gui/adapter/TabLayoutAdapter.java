package com.bwf.aiyiqi.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwf.aiyiqi.entity.TabBatchingData;
import com.bwf.aiyiqi.gui.fragment.AllFragment;
import com.bwf.aiyiqi.gui.fragment.TabFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public class TabLayoutAdapter extends FragmentPagerAdapter {
    List<String> list1 = new ArrayList<>();
    List<Fragment> fragments;
    TabBatchingData tabBatching;
    public TabLayoutAdapter(TabBatchingData tabBatching , FragmentManager fm) {
        super(fm);
        this.tabBatching = tabBatching;
       for(int i = 0;i<tabBatching.getData().size();i ++){
           list1.add(tabBatching.getData().get(i).getName());
        }
        fragments = new ArrayList<>();
        for (int i = 0; i <tabBatching.getData().size(); i++) {
            if (i == 0){
                fragments.add(new AllFragment(tabBatching.getData()));
            }else {
                fragments.add(new TabFragment(tabBatching.getData().get(i-1).getData1()));
            }
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return "全部";
        }
        return list1.get(position-1);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return tabBatching.getData().size();
    }
}
