package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.aiyiqi.entity.GreenDaoDb;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseAdapter;

/**
 * Created by Administrator on 2016/12/12.
 */

public class HistoryAdapter extends MyBaseAdapter {
    public HistoryAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView=new TextView(getContext());
        GreenDaoDb daoDbDao= (GreenDaoDb) getItem(position);
        textView.setText(daoDbDao.getContent());
        return textView;
    }
}
