package com.bwf.aiyiqi.gui.fragment;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;

/**
 * Created by Administrator on 2016/11/30.
 */

public class DecorationBudgetMine extends BaseFragment {
    @Override
    protected int getViewResId() {
        return R.layout.decoration_budget_mine;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
    public static DecorationBudgetMine newInstance(){
        DecorationBudgetMine myBudgetFragment=new DecorationBudgetMine();
        return myBudgetFragment;
    }
}
