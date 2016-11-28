package com.bwf.aiyiqi.gui.adapter.baseadapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public abstract class MyBasePagerAdapter<T> extends PagerAdapter{
    protected List<T> datas=new ArrayList<>();
    protected LayoutInflater inflater;
    private Context context;
    public MyBasePagerAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context=context;
    }
    protected  Context getContext(){
        return context;
    }
    public void setDatas(List<T> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }
    public void addDatas(List<T> datas) {
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }
    public void clearDatas( ){
        this.datas.clear();
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return datas.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}

