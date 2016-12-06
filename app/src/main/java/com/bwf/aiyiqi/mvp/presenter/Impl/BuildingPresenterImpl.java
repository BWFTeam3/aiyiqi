package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseBuilding;
import com.bwf.aiyiqi.mvp.modle.BuildingModel;
import com.bwf.aiyiqi.mvp.modle.impl.BuildingModelImpl;
import com.bwf.aiyiqi.mvp.presenter.BuildinPresenter;
import com.bwf.aiyiqi.mvp.view.BuildingView;

/**
 * Created by 11645 on 2016/12/4.
 */

public class BuildingPresenterImpl implements BuildinPresenter {
    private BuildingModel mModel;
    private BuildingView mView;

    public BuildingPresenterImpl(BuildingView mView) {
        this.mView = mView;
        mModel = new BuildingModelImpl();
    }

    @Override
    public void loadResponseDatas() {
        mModel.loadDatas(new BuildingModel.Callback() {
            @Override
            public void loadDataSuccess(ResponseBuilding data) {
                mView.showResposeSuccess(data);
            }

            @Override
            public void loadDataFailed() {
                mView.ShowFailed();
            }
        });
    }
}
