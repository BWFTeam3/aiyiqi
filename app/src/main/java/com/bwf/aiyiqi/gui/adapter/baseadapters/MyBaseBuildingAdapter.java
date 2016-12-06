package com.bwf.aiyiqi.gui.adapter.baseadapters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 11645 on 2016/12/4.
 */

public abstract class MyBaseBuildingAdapter<T> extends BaseAdapter{
    private List<T> data;
    private Context context;
    private int layoutId;

    public MyBaseBuildingAdapter(Context context, int layoutId) {
        this.context = context;
        this.data = new ArrayList<>();
        this.layoutId = layoutId;
    }

    public void clearData(){
        this.data.clear();
        notifyDataSetChanged();
    }

    public void addData(List<T> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void setData(List<T> data){
        this.data.clear();
        addData(data);
    }

    @Override
    public int getCount() {
        Log.d("MyBaseAdapter", "3 "+data.size());
        return data.size();
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("CommonBaseAdapter", "getview"+data.get(position).toString());

        MyBuildingViewHolder holder =
                MyBuildingViewHolder.getHolder(context, convertView, layoutId, parent, position);

        setViewContent(holder,data.get(position));

        Log.d("CommonBaseAdapter", "getview"+data.get(position).toString());

        return holder.getConvertView();
    }

    public abstract void setViewContent(MyBuildingViewHolder holder,T t);
}
