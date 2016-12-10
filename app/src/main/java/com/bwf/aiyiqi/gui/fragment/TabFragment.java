package com.bwf.aiyiqi.gui.fragment;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.TabBatchingData;
import com.bwf.aiyiqi.gui.adapter.GridRecycleViewAdapter;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;

import java.util.List;

import butterknife.ButterKnife;


/**
 * Created by Administrator on 2016/11/24.
 */

public class TabFragment extends BaseFragment {

    RecyclerView recycle1;
    private List<TabBatchingData.DataBean.DataBean1> data1;
    GridRecycleViewAdapter gridViewAdapter;

    public TabFragment(List<TabBatchingData.DataBean.DataBean1> data1) {
        this.data1 = data1;
    }

    @Override
    protected int getViewResId() {
        return R.layout.tablayoutfragment;
    }

    @Override
    protected void initViews() {
        recycle1 = (RecyclerView) getView().findViewById(R.id.recycle1);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle1.setLayoutManager(gridLayoutManager);
        gridViewAdapter = new GridRecycleViewAdapter(getActivity(),data1);
        recycle1.setAdapter(gridViewAdapter);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

}
