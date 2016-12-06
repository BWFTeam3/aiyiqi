package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseYiqiGroup;
import com.bwf.aiyiqi.gui.adapter.YiqiGroupGridViewAdapter;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;
import com.bwf.aiyiqi.gui.view.YiqigroupGridView;
import com.bwf.aiyiqi.mvp.presenter.Impl.YiqiGroupPresenterImpl;
import com.bwf.aiyiqi.mvp.presenter.YiqiGroupPresenter;
import com.bwf.aiyiqi.mvp.view.YiqiGroupView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/25.
 */

public class YiqiGroupFragment extends BaseFragment implements YiqiGroupView {

    @BindView(R.id.gridView_yiqigroup)
    YiqigroupGridView gridViewYiqigroup;
    @BindView(R.id.materialRefreshLayout_yiqigroup)
    MaterialRefreshLayout materialRefreshLayout;
    private String type;
    private YiqiGroupPresenter yiqiGroupPresenter;
    private YiqiGroupGridViewAdapter adapter;
    private boolean isLoding;
    private boolean noMoreData;

    @Override
    protected int getViewResId() {
        return R.layout.fragment_gridview_yiqigroup;
    }

    @Override
    protected void initViews() {
        gridViewYiqigroup.setOnScrollChangedListener(new YiqigroupGridView.OnScrollChangedListener() {
            @Override
            public void onScrollChanged(int l, int t, int oldl, int oldt) {
                if (noMoreData)
                    return;
                if (!isLoding && gridViewYiqigroup.getLastVisiblePosition()
                        == gridViewYiqigroup.getCount() - 1 && gridViewYiqigroup.getCount() != 0) {
                    yiqiGroupPresenter.loadDatas(type);
                    isLoding = true;
                }
            }
        });
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                yiqiGroupPresenter.reLoadDatas(type);
            }
        });
        adapter = new YiqiGroupGridViewAdapter(getContext());
        gridViewYiqigroup.setAdapter(adapter);
    }

    @Override
    protected void initDatas() {
        Bundle bundle = getArguments();
        type = bundle.getString("type");
        yiqiGroupPresenter = new YiqiGroupPresenterImpl(this);
        yiqiGroupPresenter.loadDatas(type);
    }

    public static YiqiGroupFragment newInstance(String type) {
        YiqiGroupFragment fragment = new YiqiGroupFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void loadSuccess(ResponseYiqiGroup responseYiqiGroup) {
        materialRefreshLayout.finishRefresh();
        adapter.addDatas(responseYiqiGroup.getData());
        isLoding = false;
    }

    @Override
    public void loadFailed(Exception e) {
        materialRefreshLayout.finishRefresh();
        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
        isLoding = false;
    }

    @Override
    public void noMoreData() {
        materialRefreshLayout.finishRefresh();
        noMoreData = true;
    }
}
