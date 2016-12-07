package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.view.MyRadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/1.
 */

public class FitsideActivity extends BaseActivity implements MyRadioGroup.OnCheckedChangeListener {

    @BindView(R.id.myradiogroup)
    MyRadioGroup myradiogroup;
    @BindView(R.id.fitside_cancle)
    ImageButton fitsideCancle;

    @Override
    protected int getViewResId() {
        return R.layout.activity_fitside;
    }

    private int stage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stage = getIntent().getIntExtra("stage", 1);
        myradiogroup.setCheckedChild(stage);
        isCreating = false;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        myradiogroup.setOnCheckedChangeListener(this);
        fitsideCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private boolean isCreating = true;

    @Override
    protected void initDatas() {

    }

    private Intent intent = new Intent();

    @Override
    public void onCheckedChanged(MyRadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radio1:
                intent.putExtra("stage", 0);
                break;
            case R.id.radio2:
                intent.putExtra("stage", 1);
                break;
            case R.id.radio3:
                intent.putExtra("stage", 2);
                break;
            case R.id.radio4:
                intent.putExtra("stage", 3);
                break;
            case R.id.radio5:
                intent.putExtra("stage", 4);
                break;
            case R.id.radio6:
                intent.putExtra("stage", 5);
                break;
            case R.id.radio7:
                intent.putExtra("stage", 6);
                break;
            case R.id.radio8:
                intent.putExtra("stage", 7);
                break;
            case R.id.radio9:
                intent.putExtra("stage", 8);
                break;
            case R.id.radio10:
                intent.putExtra("stage", 9);
                break;
            case R.id.radio11:
                intent.putExtra("stage", 10);
                break;
            case R.id.radio12:
                intent.putExtra("stage", 11);
                break;
            case R.id.radio13:
                intent.putExtra("stage", 12);
                break;
            case R.id.radio14:
                intent.putExtra("stage", 13);
                break;
            case R.id.radio15:
                intent.putExtra("stage", 14);
                break;
            case R.id.radio16:
                intent.putExtra("stage", 15);
                break;
            case R.id.radio17:
                intent.putExtra("stage", 16);
                break;
        }
        if (!isCreating) {
            FitsideActivity.this.setResult(1985, intent);
            finish();
        }

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.right_stay,R.anim.right_out);
    }
}
