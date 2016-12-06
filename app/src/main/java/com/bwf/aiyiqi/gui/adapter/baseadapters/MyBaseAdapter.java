package com.bwf.aiyiqi.gui.adapter.baseadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;

import com.bwf.aiyiqi.gui.adapter.MainRecycleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {
    protected List<T> datas;
    private Context context;
    protected LayoutInflater inflater;

    public MyBaseAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
        inflater = LayoutInflater.from(context);
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

    public void clearDatas() {
        this.datas.clear();
        notifyDataSetChanged();
    }

    @Override
    public T getItem(int position) {
        return datas.get(position);
    }

    protected Context getContext() {
        return context;
    }

    @Override
    public int getCount() {
        return datas.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    public interface OnItemClickListener<T> {
        void onItemClick(View view, int pesition, T data);
    }

    protected MyBaseAdapter.OnItemClickListener itenListener;

    public void setOnItemClickListener(MyBaseAdapter.OnItemClickListener itenListener) {
        this.itenListener = itenListener;
    }
    private int clickPosition;
    public void setClickPosition(int clickPosition) {
        this.clickPosition=clickPosition;
    }

    protected class BaseHolder {
        public BaseHolder(View view) {
            view.setTag(MainRecycleAdapter.CONTENT);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itenListener != null) {
                        itenListener.onItemClick(v, clickPosition, getItem(clickPosition));
                    }
                }
            });
        }
    }
}
