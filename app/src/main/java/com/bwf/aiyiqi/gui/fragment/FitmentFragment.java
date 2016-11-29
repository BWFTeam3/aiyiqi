package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;
import com.bwf.aiyiqi.mvp.presenter.FitmentPresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.FitmentPresenterImpl;
import com.bwf.aiyiqi.mvp.view.FitmentView;
import com.cjj.MaterialRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/28.
 */

public class FitmentFragment extends BaseFragment implements FitmentView {
    @BindView(R.id.fitment_recycleview)
    RecyclerView fitmentRecycleview;
    @BindView(R.id.fitment_refresh)
    MaterialRefreshLayout fitmentRefresh;

    @Override
    protected int getViewResId() {
        return R.layout.fitment_fragment;
    }

    @Override
    protected void initViews() {

    }

    private int stage;
    private FitmentPresenter presenter;

    @Override
    protected void initDatas() {
        Bundle bundle = getArguments();
        stage = bundle.getInt("stage");
        presenter = new FitmentPresenterImpl(this);
        presenter.loadTags(stage);
    }

    @Override
    public void showTagsSuccess(String response) {

    }

    @Override
    public void showTagsFaild(Exception e) {

    }

    @Override
    public void showNewsSuccess(String response) {

    }

    @Override
    public void showNewsFaild(Exception e) {

    }

    @Override
    public void showNextSuccess(String response) {

    }

    @Override
    public void showNextFaild(Exception e) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
