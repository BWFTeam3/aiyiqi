package com.bwf.aiyiqi.gui.fragment.OwnerTalk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseSection;
import com.bwf.aiyiqi.gui.adapter.SectionFragmentGridLinkAdapter;
import com.bwf.aiyiqi.gui.adapter.SectionFragmentGridShopAdapter;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;
import com.bwf.aiyiqi.gui.view.MyGridView;
import com.bwf.aiyiqi.mvp.presenter.Impl.SectionPresenterImpl;
import com.bwf.aiyiqi.mvp.presenter.SectionPresenter;
import com.bwf.aiyiqi.mvp.view.SectionView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/4.
 */

public class SectionFragment extends BaseFragment implements SectionView {
    @BindView(R.id.gridView_link)
    MyGridView gridViewLink;
    @BindView(R.id.gridView_shop)
    MyGridView gridViewShop;
    @BindView(R.id.materialRefreshLayout_section_fragment)
    MaterialRefreshLayout materialRefreshLayoutSectionFragment;
    private SectionPresenter sectionPresenter;
    private SectionFragmentGridLinkAdapter sectionFragmentGridLinkAdapter;
    private SectionFragmentGridShopAdapter sectionFragmentGridShopAdapter;

    @Override
    protected int getViewResId() {
        return R.layout.section_fragment;
    }

    @Override
    protected void initViews() {
        sectionFragmentGridLinkAdapter = new SectionFragmentGridLinkAdapter(getActivity());
        sectionFragmentGridShopAdapter = new SectionFragmentGridShopAdapter(getActivity());
        gridViewLink.setAdapter(sectionFragmentGridLinkAdapter);
        gridViewShop.setAdapter(sectionFragmentGridShopAdapter);
        materialRefreshLayoutSectionFragment.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                sectionPresenter.loadDatas();
            }
        });
    }

    @Override
    protected void initDatas() {
        sectionPresenter = new SectionPresenterImpl(this);
        sectionPresenter.loadDatas();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void loadDatasSuccess(ResponseSection responseSection) {
        materialRefreshLayoutSectionFragment.finishRefresh();
        sectionFragmentGridLinkAdapter.setDatas(responseSection.getData());
        sectionFragmentGridShopAdapter.setDatas(responseSection.getData());
    }

    @Override
    public void loadDatasFailed(Exception e) {
        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
