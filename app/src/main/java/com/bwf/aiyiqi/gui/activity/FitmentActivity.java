package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageButton;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.adapter.FitmentPagerAdapter;
import com.bwf.aiyiqi.gui.fragment.FitmentFragment;
import com.cjj.MaterialRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/28.
 */

public class FitmentActivity extends BaseActivity {
    @BindView(R.id.fitment_imgbutton1)
    ImageButton fitmentImgbutton1;
    @BindView(R.id.fitment_tablayout)
    TabLayout fitmentTablayout;
    @BindView(R.id.fitment_imgbutton2)
    ImageButton fitmentImgbutton2;
    @BindView(R.id.fitment_viewpager)
    ViewPager fitmentViewpager;
    @BindView(R.id.fitment_refresh)
    MaterialRefreshLayout fitmentRefresh;
    private PagerAdapter adapter;
    private String tab[]={"验房收房","装修公司","量房设计","辅材选购","主材选购","家居选购","装修合同","主题拆迁","水电改造","防水处理","土木工程","瓦工工程","油工工程","主材安装","竣工验收","软装配饰","居家生活"};
    private List<Fragment> list;
    @Override
    protected int getViewResId() {
        return R.layout.activity_fitment;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        list=new ArrayList<>();
        for (int i = 0; i < tab.length; i++) {
           Fragment fragment= new FitmentFragment();
            Bundle bundle=new Bundle();
            bundle.putInt("stage",i+1);
            fragment.setArguments(bundle);
            list.add(fragment);
        }
        adapter=new FitmentPagerAdapter(getSupportFragmentManager(),list,tab);
        fitmentViewpager.setAdapter(adapter);
        fitmentTablayout.setupWithViewPager(fitmentViewpager);
    }

    @Override
    protected void initDatas() {

    }


}
