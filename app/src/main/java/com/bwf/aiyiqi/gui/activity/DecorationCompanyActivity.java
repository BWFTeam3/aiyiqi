package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseFitmentLive;
import com.bwf.aiyiqi.entity.ResponseFlashView;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.adapter.DecorationCompanyViewPagerAdapter;
import com.bwf.aiyiqi.mvp.presenter.DecorationCompanyPresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.DecorationCompanyPresenterImpl;
import com.bwf.aiyiqi.mvp.view.DecorationCompanyView;
import com.bwf.aiyiqi.gui.view.AutoScrollViewPager;
import com.bwf.aiyiqi.widget.PagerDotIndicator;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/23.
 */

public class DecorationCompanyActivity extends BaseActivity implements DecorationCompanyView {
    @BindView(R.id.imageView_title)
    ImageView imageViewTitle;
    @BindView(R.id.viewPager_decoration_company)
    AutoScrollViewPager viewPagerDecorationCompany;
    @BindView(R.id.linearLayout_decoration_company_pager_dot)
    LinearLayout linearLayoutDecorationCompanyPagerDot;
    @BindView(R.id.textView_new_house_prise)
    TextView textViewNewHousePrise;
    @BindView(R.id.linearLayout_new_house)
    LinearLayout linearLayoutNewHouse;
    @BindView(R.id.textView_old_house_prise)
    TextView textViewOldHousePrise;
    @BindView(R.id.linearLayout_old_house)
    LinearLayout linearLayoutOldHouse;
    @BindView(R.id.linearLayout_look_site)
    LinearLayout linearLayoutLookSite;
    @BindView(R.id.linearLayout_site_playing)
    LinearLayout linearLayoutSitePlaying;
    @BindView(R.id.linearLayout_yiqi_group)
    LinearLayout linearLayoutYiqiGroup;
    @BindView(R.id.linearLayout_fitment_live)
    LinearLayout linearLayoutFitmentLive;
    @BindView(R.id.materialRefreshLayout_decoration_company)
    MaterialRefreshLayout materialRefreshLayout;
    @BindView(R.id.textView_title)
    TextView textViewTitle;
    private DecorationCompanyPresenter decorationCompanyPresenter;
    private LayoutInflater inflater;
    private DecorationCompanyViewPagerAdapter pagerAdapter;
    private List<View> views;
    private PagerDotIndicator pagerDotIndicator;

    @Override
    protected int getViewResId() {
        return R.layout.subview_decoration_company;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        inflater = LayoutInflater.from(this);
        views = new ArrayList<>();
        pagerDotIndicator = new PagerDotIndicator(this, linearLayoutDecorationCompanyPagerDot, viewPagerDecorationCompany);
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                decorationCompanyPresenter.loadDatas();
            }
        });
        pagerAdapter = new DecorationCompanyViewPagerAdapter(this, views);
        viewPagerDecorationCompany.setAdapter(pagerAdapter);

    }

    @Override
    protected void initDatas() {
        decorationCompanyPresenter = new DecorationCompanyPresenterImpl(this);
        decorationCompanyPresenter.loadDatas();
    }


    @Override
    public void loadFlashViewSuccess(ResponseFlashView responseFlashView) {
        materialRefreshLayout.finishRefresh();
        pagerDotIndicator.setDotNums(responseFlashView.getData().size());
        for (ResponseFlashView.DataBean dataBean : responseFlashView.getData()) {
            View view = inflater.inflate(R.layout.view_simpledraweeview, null);
            views.add(view);
        }

        pagerAdapter.addDatas(responseFlashView.getData());

    }

    @Override
    public void loadFlashViewFailed(Exception e) {
        materialRefreshLayout.finishRefresh();
        Toast.makeText(DecorationCompanyActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadFitmentLiveSuccess(ResponseFitmentLive responseFitmentLive) {
        for (int i = 0; i < responseFitmentLive.getData().size(); i++) {
            View view = inflater.inflate(R.layout.item_decoration_company_fitment_live, null);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.simpleDraweeView_fitment_live);
            simpleDraweeView.setImageURI(responseFitmentLive.getData().get(i).getImageUrl());
            TextView textViewTop = (TextView) view.findViewById(R.id.textView_fitment_live_top);
            TextView textViewBottom = (TextView) view.findViewById(R.id.textView_fitment_live_bottom);
            textViewTop.setText(responseFitmentLive.getData().get(i).getOrderHouse().getCommunity());
            textViewBottom.setText(responseFitmentLive.getData().get(i).getOrderHouse().getLayout());
            if (i == responseFitmentLive.getData().size() - 1) {
                TextView textView = (TextView) view.findViewById(R.id.textView_no_more_datas);
                textView.setVisibility(View.VISIBLE);
            }
            linearLayoutFitmentLive.addView(view);
        }
    }

    @Override
    public void loadFitmentLiveFailed(Exception e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.imageView_title, R.id.linearLayout_new_house, R.id.linearLayout_old_house, R.id.linearLayout_look_site, R.id.linearLayout_site_playing, R.id.linearLayout_yiqi_group, R.id.linearLayout_fitment_live})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView_title:
                finish();
                break;
            case R.id.linearLayout_new_house:
                break;
            case R.id.linearLayout_old_house:
                break;
            case R.id.linearLayout_look_site:
                break;
            case R.id.linearLayout_site_playing:
                break;
            case R.id.linearLayout_yiqi_group:
                break;
            case R.id.linearLayout_fitment_live:
                break;
        }
    }
}
