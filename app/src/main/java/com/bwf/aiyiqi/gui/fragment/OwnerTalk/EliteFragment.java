package com.bwf.aiyiqi.gui.fragment.OwnerTalk;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseElite;
import com.bwf.aiyiqi.gui.adapter.EliteFragmentRecyclerAdapter;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;
import com.bwf.aiyiqi.mvp.presenter.ElitePresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.ElitePresenterImpl;
import com.bwf.aiyiqi.mvp.view.EliteView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/4.
 */

public class EliteFragment extends BaseFragment implements EliteView {
    @BindView(R.id.recycle_elite_fragment)
    RecyclerView recycleEliteFragment;
    @BindView(R.id.materialRefreshLayout_elite_fragment)
    MaterialRefreshLayout materialRefreshLayoutEliteFragment;
    private ElitePresenter elitePresenter;
    private EliteFragmentRecyclerAdapter adapter;

    @Override
    protected int getViewResId() {
        return R.layout.elite_fragment;
    }

    @Override
    protected void initViews() {
        adapter = new EliteFragmentRecyclerAdapter(getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleEliteFragment.setLayoutManager(manager);
        recycleEliteFragment.setAdapter(adapter);
        materialRefreshLayoutEliteFragment.setLoadMore(true);
        materialRefreshLayoutEliteFragment.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                adapter.clearDatas();
                elitePresenter.reLoadDatas();
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                elitePresenter.loadDatas();
            }
        });

    }

    @Override
    protected void initDatas() {
        elitePresenter = new ElitePresenterImpl(this);
        elitePresenter.loadDatas();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void loadSuccess(ResponseElite responseElite) {
        materialRefreshLayoutEliteFragment.finishRefresh();
        materialRefreshLayoutEliteFragment.finishRefreshLoadMore();
        adapter.addDatas(responseElite.getData());
    }

    @Override
    public void loadFailed(Exception e) {
        materialRefreshLayoutEliteFragment.finishRefresh();
        materialRefreshLayoutEliteFragment.finishRefreshLoadMore();
        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void noMoreData() {
        materialRefreshLayoutEliteFragment.setLoadMore(false);
    }
}
