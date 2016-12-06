package com.bwf.aiyiqi.gui.fragment.OwnerTalk;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseNewest;
import com.bwf.aiyiqi.gui.adapter.NewestFragmentRecyclerAdapter;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;
import com.bwf.aiyiqi.mvp.presenter.Impl.NewestpresenterImpl;
import com.bwf.aiyiqi.mvp.presenter.Newestpresenter;
import com.bwf.aiyiqi.mvp.view.NewestView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/4.
 */

public class NewestFragment extends BaseFragment implements NewestView {
    @BindView(R.id.recycle_newest_fragment)
    RecyclerView recycleNewestFragment;
    @BindView(R.id.materialRefreshLayout_newest_fragment)
    MaterialRefreshLayout materialRefreshLayoutNewestFragment;
    private Newestpresenter newestpresenter;
    private NewestFragmentRecyclerAdapter adapter;
    private LinearLayoutManager manager;

    @Override
    protected int getViewResId() {
        return R.layout.newest_fragment;
    }

    @Override
    protected void initViews() {
        adapter = new NewestFragmentRecyclerAdapter(getActivity());
        manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleNewestFragment.setLayoutManager(manager);
        recycleNewestFragment.setAdapter(adapter);
        materialRefreshLayoutNewestFragment.setLoadMore(true);
        materialRefreshLayoutNewestFragment.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                adapter.clearDatas();
                newestpresenter.reLoadDatas();
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                newestpresenter.loadDatas();
            }
        });
    }

    @Override
    protected void initDatas() {
        newestpresenter = new NewestpresenterImpl(this);
        newestpresenter.loadDatas();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void loadDatasSuccess(ResponseNewest responseNewest) {
        materialRefreshLayoutNewestFragment.finishRefresh();
        materialRefreshLayoutNewestFragment.finishRefreshLoadMore();
        adapter.addDatas(responseNewest.getData());

    }

    @Override
    public void loadDatasFailed(Exception e) {
        materialRefreshLayoutNewestFragment.finishRefresh();
        materialRefreshLayoutNewestFragment.finishRefreshLoadMore();
        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void noMoreData() {
        materialRefreshLayoutNewestFragment.setLoadMore(false);
    }
}
