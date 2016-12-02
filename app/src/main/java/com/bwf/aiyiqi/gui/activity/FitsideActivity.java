package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.view.CustomNestRadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/1.
 */

public class FitsideActivity extends BaseActivity implements CustomNestRadioGroup.OnCheckedChangeListener{

    @BindView(R.id.myradiogroup)
    CustomNestRadioGroup myradiogroup;

    @Override
    protected int getViewResId() {
        return R.layout.activity_fitside;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        myradiogroup.setOnCheckedChangeListener(this);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }

    @Override
    public void onCheckedChanged(CustomNestRadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.radio1:

                break;
            case R.id.radio2:

                break;
            case R.id.radio3:

                break;
            case R.id.radio4:

                break;
            case R.id.radio5:

                break;
            case R.id.radio6:

                break;
            case R.id.radio7:

                break;
            case R.id.radio8:

                break;
            case R.id.radio9:

                break;
            case R.id.radio10:

                break;
            case R.id.radio11:

                break;
            case R.id.radio12:

                break;
            case R.id.radio13:

                break;
            case R.id.radio14:

                break;
            case R.id.radio15:

                break;
            case R.id.radio16:

                break;
            case R.id.radio17:

                break;


        }
    }
}
