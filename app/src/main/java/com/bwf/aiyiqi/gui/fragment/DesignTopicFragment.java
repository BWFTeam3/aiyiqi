package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseDesignTopic;
import com.bwf.aiyiqi.gui.adapter.DesignTopicAdapter;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseRecycleAdapter;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;
import com.bwf.aiyiqi.mvp.presenter.DesignTopicPresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.DesignTopicPresenterImpl;
import com.bwf.aiyiqi.mvp.view.DesignView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Phyj on 2016/12/3.
 */

public class DesignTopicFragment extends BaseFragment implements DesignView, MyBaseRecycleAdapter.OnItemClickListener {
    @BindView(R.id.design_recyclerview)
    RecyclerView designRecyclerview;
    @BindView(R.id.design_refresh)
    MaterialRefreshLayout designRefresh;
    private DesignTopicPresenter presenter;
    private DesignTopicAdapter adapter;
    private LinearLayoutManager manager;
    private boolean isloading;

    @Override
    protected int getViewResId() {
        return R.layout.designtopic_fragment;
    }

    @Override
    protected void initViews() {
        manager = new LinearLayoutManager(getContext());
        designRecyclerview.setLayoutManager(manager);
        adapter = new DesignTopicAdapter(getContext());
        designRecyclerview.setAdapter(adapter);
        designRefresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                presenter.loadDatas();
            }
        });
        adapter.setOnItemClickListener(this);
        designRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (totalCount == manager.findLastVisibleItemPosition()) {
                    Toast.makeText(getContext(), "没有更多数据了", Toast.LENGTH_SHORT).show();
                    isloading = true;
                    return;
                }
                if (!isloading && manager.findLastVisibleItemPosition() == adapter.getItemCount() - 1) {
                    presenter.loadNextDatas();
                    isloading = true;
                }
            }
        });
    }

    @Override
    protected void initDatas() {
        presenter = new DesignTopicPresenterImpl(this);
        isloading = true;
        presenter.loadDatas();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    private int totalCount = -1;

    @Override
    public void showSuccess(String response) {
        isloading = false;
        designRefresh.finishRefresh();
        ResponseDesignTopic responseDesignTopic = JSON.parseObject(response, ResponseDesignTopic.class);
        if ("0".equals(responseDesignTopic.getMessage())) {
            totalCount = Integer.parseInt(responseDesignTopic.getData().getTotalCount());
            adapter.setDatas(responseDesignTopic.getData().getList());
        }
    }

    @Override
    public void showFaild(Exception e) {
        isloading = false;
        designRefresh.finishRefresh();
        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNextSuccess(String response) {
        isloading = false;
        designRefresh.finishRefresh();
        ResponseDesignTopic responseDesignTopic = JSON.parseObject(response, ResponseDesignTopic.class);
        if ("0".equals(responseDesignTopic.getMessage())) {
            adapter.addDatas(responseDesignTopic.getData().getList());
        }
    }

    @Override
    public void showNextFaild(Exception e) {
        isloading = false;
        designRefresh.finishRefresh();
        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(View view, int pesition, Object data) {
        Toast.makeText(getContext(), "hehe", Toast.LENGTH_SHORT).show();
    }
}
