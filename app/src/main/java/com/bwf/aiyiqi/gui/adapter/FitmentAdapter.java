package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseRecycleAdapter;

/**
 * Created by Administrator on 2016/11/28.
 */

public class FitmentAdapter extends MyBaseRecycleAdapter {
    public FitmentAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getFooterCount() {
        return 1;
    }

    @Override
    protected int getHeaderCount() {
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
}
