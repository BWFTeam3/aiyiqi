package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;

/**
 * Created by Administrator on 2016/11/28.
 */

public class FitmentFragment extends BaseFragment{
    @Override
    protected int getViewResId() {
        return R.layout.fitment_fragment;
    }

    @Override
    protected void initViews() {

    }
    private int stage;
    @Override
    protected void initDatas() {
        Bundle bundle=getArguments();
        stage=bundle.getInt("stage");
    }

}
