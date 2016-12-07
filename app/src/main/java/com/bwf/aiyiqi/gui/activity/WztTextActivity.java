package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 11645 on 2016/12/4.
 */

public class WztTextActivity extends BaseActivity {

    @BindView(R.id.popupwindow_linearlayout1)
    LinearLayout popupwindowLinearlayout1;
    @BindView(R.id.popupwindow_linearlayout2)
    LinearLayout popupwindowLinearlayout2;
    @BindView(R.id.popupwindow_linearlayout3)
    LinearLayout popupwindowLinearlayout3;
    @BindView(R.id.popupwindow_linearlayout4)
    LinearLayout popupwindowLinearlayout4;
    @BindView(R.id.create_feed_normal)
    ImageButton createFeedNormal;
    private int width;
    private int height;
    private RelativeLayout.LayoutParams layoutParams1, layoutParams2, layoutParams3, layoutParams4;

    @Override
    protected int getViewResId() {
        return R.layout.popupwindow;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
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
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        width = getResources().getDisplayMetrics().widthPixels;
        height = getResources().getDisplayMetrics().heightPixels;
        layoutParams1 = (RelativeLayout.LayoutParams) popupwindowLinearlayout1.getLayoutParams();
        layoutParams2 = (RelativeLayout.LayoutParams) popupwindowLinearlayout2.getLayoutParams();
        layoutParams3 = (RelativeLayout.LayoutParams) popupwindowLinearlayout3.getLayoutParams();
        layoutParams4 = (RelativeLayout.LayoutParams) popupwindowLinearlayout4.getLayoutParams();
        layoutParams1.setMargins(width / 5, height / 6, 0, 0);
        layoutParams2.setMargins(0, height / 6, width / 5, 0);
        layoutParams3.setMargins(width / 5, height / 6 * 3, 0, 0);
        layoutParams4.setMargins(0, height / 6 * 3, width / 5, 0);
        inTo();
    }


    private void inTo() {
        AnimationSet animationSet1 = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.anim_1);
        popupwindowLinearlayout1.startAnimation(animationSet1);
        AnimationSet animationSet2 = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.anim_2);
        popupwindowLinearlayout2.startAnimation(animationSet2);
        AnimationSet animationSet3 = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.anim_3);
        popupwindowLinearlayout3.startAnimation(animationSet3);
        AnimationSet animationSet4 = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.anim_4);
        popupwindowLinearlayout4.startAnimation(animationSet4);
    }

    private void outTo() {
        Animation animationOut1 = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.outanim_1);
        popupwindowLinearlayout1.clearAnimation();
        popupwindowLinearlayout1.startAnimation(animationOut1);
        Animation animationOut2 = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.outanim_2);
        popupwindowLinearlayout2.clearAnimation();
        popupwindowLinearlayout2.startAnimation(animationOut2);
        animationOut2.setFillAfter(true);
        Animation animationOut3 = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.outanim_3);
        popupwindowLinearlayout3.clearAnimation();
        popupwindowLinearlayout3.startAnimation(animationOut3);
        Animation animationOut4 = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.outanim_4);
        popupwindowLinearlayout4.clearAnimation();
        popupwindowLinearlayout4.startAnimation(animationOut4);
        animationOut4.setFillAfter(true);
        animationOut2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                overridePendingTransition(R.anim.menushow, R.anim.menuhide);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @OnClick({R.id.popupwindow_linearlayout1, R.id.popupwindow_linearlayout2, R.id.popupwindow_linearlayout3, R.id.popupwindow_linearlayout4, R.id.essence_fragmenat_button_close, R.id.rl_popupwindow})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.popupwindow_linearlayout1:
                Toast.makeText(this, "发帖", Toast.LENGTH_SHORT).show();
                break;
            case R.id.popupwindow_linearlayout2:
                Toast.makeText(this, "晒单", Toast.LENGTH_SHORT).show();
                break;
            case R.id.popupwindow_linearlayout3:
                Toast.makeText(this, "日记", Toast.LENGTH_SHORT).show();
                break;
            case R.id.popupwindow_linearlayout4:
                Toast.makeText(this, "投诉/表扬", Toast.LENGTH_SHORT).show();
                break;
            case R.id.essence_fragmenat_button_close:
                outTo();
                break;
            case R.id.rl_popupwindow:
                outTo();
                break;
        }
    }
}

