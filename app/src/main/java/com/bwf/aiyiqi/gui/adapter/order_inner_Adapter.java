package com.bwf.aiyiqi.gui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.bwf.aiyiqi.gui.fragment.string_text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/5.
 */

public class order_inner_Adapter extends FragmentPagerAdapter {
    List<String> names;
    List<Fragment> pagers;
    String discount_info;
    public order_inner_Adapter(FragmentManager fm, String discount_info) {
        super(fm);
        names = new ArrayList<>();
        pagers = new ArrayList<>();
        this.discount_info =discount_info;
        names.add("折扣");
        names.add("帖子");
        names.add("评价");

        pagers.add(new string_text(discount_info));
        pagers.add(new string_text(discount_info));
        pagers.add(new string_text(discount_info));


    }

    @Override
    public Fragment getItem(int position) {
        return pagers.get(position);
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return names.get(position);
    }
}
