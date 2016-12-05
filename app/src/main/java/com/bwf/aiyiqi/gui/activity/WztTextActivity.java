package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 11645 on 2016/12/4.
 */

public class WztTextActivity extends BaseActivity {

    @BindView(R.id.float_layer_layout)
    RelativeLayout floatLayerLayout;
    @BindView(R.id.float_layer_menu)
    ImageView floatLayerMenu;

    @Override
    protected int getViewResId() {
        return R.layout.owner_classify_item;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.float_layer_layout, R.id.float_layer_menu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.float_layer_layout:
                break;
            case R.id.float_layer_menu:
                if (floatLayerLayout.getVisibility() == View.VISIBLE){
                    floatLayerLayout.isShown();
                }else {
                    floatLayerLayout.setVisibility(View.VISIBLE);
                    floatLayerLayout.isShown();
                }
                break;
        }
    }
}
