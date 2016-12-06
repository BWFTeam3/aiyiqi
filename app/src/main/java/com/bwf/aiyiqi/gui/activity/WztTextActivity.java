package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 11645 on 2016/12/4.
 */

public class WztTextActivity extends BaseActivity {


    @BindView(R.id.float_layer_first)
    TextView floatLayerFirst;
    @BindView(R.id.float_layer_second)
    TextView floatLayerSecond;
    @BindView(R.id.float_layer_third)
    TextView floatLayerThird;
    @BindView(R.id.float_layer_forth)
    TextView floatLayerForth;
    @BindView(R.id.float_layer_layout)
    RelativeLayout floatLayerLayout;
    @BindView(R.id.float_layer_menu)
    ImageButton floatLayerMenu;

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
    }


    @OnClick(R.id.float_layer_menu)
    public void onClick() {
        if (floatLayerFirst.getVisibility() == View.VISIBLE ) {
            floatLayerLayout.setVisibility(View.GONE);
        }
    }
}

