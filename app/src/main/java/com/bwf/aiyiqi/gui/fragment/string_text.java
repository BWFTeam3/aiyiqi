package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/5.
 */

public class string_text extends BaseFragment {
    String discount_info;
    @BindView(R.id.te2)
    TextView te2;

    public string_text(String discount_info) {
        this.discount_info = discount_info;
    }

    @Override
    protected int getViewResId() {
        return R.layout.string_text;
    }

    @Override
    protected void initViews() {
        te2.setText(discount_info);
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
