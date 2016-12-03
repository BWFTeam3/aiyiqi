package com.bwf.aiyiqi.gui.activity.DecorationCompany;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.adapter.ViewPagerPageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/29.
 */

public class PageAcitivity extends BaseActivity {
    @BindView(R.id.viewPager_page)
    ViewPager viewPagerPage;
    @BindView(R.id.textView_page)
    TextView textViewPage;

    @Override
    protected int getViewResId() {
        return R.layout.subview_page;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        Intent intent = getIntent();
        final ArrayList<String> urls = intent.getStringArrayListExtra("urls");
        int position = intent.getIntExtra("position", 0);
        List<View> views = new ArrayList<>();
        for (String url : urls) {
            View view = View.inflate(this, R.layout.simple_drawee_view_page, null);
            views.add(view);
        }
        ViewPagerPageAdapter viewPagerPageAdapter = new ViewPagerPageAdapter(this, views);
        viewPagerPage.setAdapter(viewPagerPageAdapter);
        viewPagerPageAdapter.setDatas(urls);
        viewPagerPage.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                textViewPage.setText((position + 1) + "/" + urls.size());
            }
        });
        viewPagerPage.setCurrentItem(position);
        textViewPage.setText((position + 1) + "/" + urls.size());
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }
}
