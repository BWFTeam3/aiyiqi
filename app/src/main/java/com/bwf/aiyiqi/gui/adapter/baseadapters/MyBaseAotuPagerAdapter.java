package com.bwf.aiyiqi.gui.adapter.baseadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public abstract class MyBaseAotuPagerAdapter<T> extends MyBasePagerAdapter<T>{
    protected List<View> views;
    protected LayoutInflater inflater;
    public MyBaseAotuPagerAdapter(Context context,List<View> views) {
        super(context);
        this.inflater = LayoutInflater.from(context);
        this.views=views;
    }
}
