package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.adapter.FitmentPagerAdapter;
import com.bwf.aiyiqi.gui.fragment.FitmentFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/28.
 */

public class FitmentActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.fitment_imgbutton1)
    ImageButton fitmentImgbutton1;
    @BindView(R.id.fitment_tablayout)
    TabLayout fitmentTablayout;
    @BindView(R.id.fitment_imgbutton2)
    ImageButton fitmentImgbutton2;
    @BindView(R.id.fitment_viewpager)
    ViewPager fitmentViewpager;
    //    private String tab[];
    private String tab[] = {"验房收房", "装修公司", "量房设计", "辅材选购", "主材选购", "家居选购", "装修合同", "主题拆迁", "水电改造", "防水处理", "土木工程", "瓦工工程", "油工工程", "主材安装", "竣工验收", "软装配饰", "居家生活"};
    private PagerAdapter adapter;
    private List<Fragment> list;

    @Override
    protected int getViewResId() {
        return R.layout.activity_fitment;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        fitmentImgbutton1.setOnClickListener(this);
        fitmentImgbutton2.setOnClickListener(this);
        list = new ArrayList<>();
        for (int i = 0; i < tab.length; i++) {
            Fragment fragment = new FitmentFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("stage", i + 1);
            fragment.setArguments(bundle);
            list.add(fragment);
        }
        adapter = new FitmentPagerAdapter(getSupportFragmentManager(), list, tab);
        fitmentViewpager.setAdapter(adapter);
        fitmentTablayout.setupWithViewPager(fitmentViewpager);
    }

    @Override
    protected void initDatas() {

    }

    public static final int FITMENTREQUESTCODE = 1984;
    public static final int FITMENTRESULTCODE = 1985;

    @Override
    public void onClick(View v) {
        int stage = fitmentViewpager.getCurrentItem();
        if (v == fitmentImgbutton1) {
            finish();
        } else {
            Intent intent = new Intent(this, FitsideActivity.class);
            intent.putExtra("stage", stage);
            startActivityForResult(intent, FITMENTREQUESTCODE);
            overridePendingTransition(R.anim.right_in,R.anim.right_stay);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==FITMENTREQUESTCODE&&resultCode==FITMENTRESULTCODE){
            if (data!=null){
                int stage = data.getIntExtra("stage",0);
                fitmentViewpager.setCurrentItem(stage);
            }
        }

    }
}
