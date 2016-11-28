package com.bwf.aiyiqi.gui.adapter.baseadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {
    private List<T>datas;
    private Context context;
    protected LayoutInflater inflater;

    public MyBaseAdapter(Context context) {
        this.context = context;
        datas=new ArrayList<>();
        inflater=LayoutInflater.from(context);
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
    public T getItem(int position) {
        return datas.get(position);
    }

    protected  Context getContext(){
        return context;
    }

}
