package com.bwf.aiyiqi.gui.activity.CityEvent;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseCityEvent;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.adapter.CityEventRecyclerAdapter;
import com.bwf.aiyiqi.mvp.presenter.CityEventPresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.CityEventPresenterImpl;
import com.bwf.aiyiqi.mvp.view.CityEventView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/30.
 */

public class CityEventActivity extends BaseActivity implements CityEventView {
    @BindView(R.id.textView_title)
    TextView textViewTitle;
    @BindView(R.id.recycle_city_event)
    RecyclerView recycleCityEvent;
    @BindView(R.id.materialRefreshLayout_city_event)
    MaterialRefreshLayout materialRefreshLayoutCityEvent;
    private CityEventPresenter cityEventPresenter;
    private CityEventRecyclerAdapter cityEventRecyclerAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected int getViewResId() {
        return R.layout.subview_city_event;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        textViewTitle.setText("同城活动");
        cityEventRecyclerAdapter = new CityEventRecyclerAdapter(this);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleCityEvent.setLayoutManager(layoutManager);
        recycleCityEvent.setAdapter(cityEventRecyclerAdapter);
        materialRefreshLayoutCityEvent.setLoadMore(true);
        materialRefreshLayoutCityEvent.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                cityEventRecyclerAdapter.clearDatas();
                cityEventPresenter.reloadDatas();
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);
                cityEventPresenter.loadDatas();
            }
        });

    }

    @Override
    protected void initDatas() {
        cityEventPresenter = new CityEventPresenterImpl(this);
        cityEventPresenter.loadDatas();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
    }

    @OnClick(R.id.imageView_title)
    public void onClick() {
        finish();
    }

    @Override
    public void loadDatasSuccess(ResponseCityEvent responseCityEvent) {
        materialRefreshLayoutCityEvent.finishRefresh();
        cityEventRecyclerAdapter.addDatas(responseCityEvent.getData().getForumlist());
    }

    @Override
    public void loadDatasFailed(Exception e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void noMoreData() {
        materialRefreshLayoutCityEvent.setLoadMore(false);
    }
}
