package com.bwf.aiyiqi.mvp.presenter.Impl;


import com.bwf.aiyiqi.entity.TabBatchingData;
import com.bwf.aiyiqi.mvp.modle.TabBatching;
import com.bwf.aiyiqi.mvp.modle.impl.TabBatchingImpl;
import com.bwf.aiyiqi.mvp.presenter.TabPresenter;
import com.bwf.aiyiqi.mvp.view.ShowData;

/**
 * Created by Administrator on 2016/11/24.
 */

public class TabPresenterImpl implements TabPresenter {
    TabBatching tabBatching;
    ShowData showData;

    public TabPresenterImpl(ShowData showData) {
        this.tabBatching = new TabBatchingImpl();
        this.showData = showData;
    }

    @Override
    public void TabDataLoad() {
            tabBatching.LoadTabBatching(new TabBatching.TabBatchingLoadingCallBack() {
                @Override
                public void LoadSuccess(TabBatchingData tabBatching) {
                    showData.showSuccess(tabBatching);
                }

                @Override
                public void LoadFaild() {

                }
            });
    }
}
