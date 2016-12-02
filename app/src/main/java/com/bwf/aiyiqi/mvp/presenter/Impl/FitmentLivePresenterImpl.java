package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseBasicInformation;
import com.bwf.aiyiqi.entity.ResponseFitmentPorgress;
import com.bwf.aiyiqi.mvp.modle.FitmentLiveModel;
import com.bwf.aiyiqi.mvp.modle.impl.FitmentLiveModelImpl;
import com.bwf.aiyiqi.mvp.presenter.FitmentLivePresenter;
import com.bwf.aiyiqi.mvp.view.FitmentLiveView;

/**
 * Created by Administrator on 2016/11/27.
 */

public class FitmentLivePresenterImpl implements FitmentLivePresenter {
    private FitmentLiveModel fitmentLiveModel;
    private FitmentLiveView fitmentLiveView;
    private int nextPage = 0;
    private final int pageSize = 10;

    public FitmentLivePresenterImpl(FitmentLiveView fitmentLiveView) {
        this.fitmentLiveModel = new FitmentLiveModelImpl();
        this.fitmentLiveView = fitmentLiveView;
    }

    @Override
    public void loadDatas(String progressId, String buildingId) {
        fitmentLiveModel.loadBaseInformationDatas(buildingId, new FitmentLiveModel.CallbcakBaseInformation() {
            @Override
            public void loadBaseInformationDatasSuccess(ResponseBasicInformation responseBasicInformation) {
                fitmentLiveView.loadBaseInformationDatasSuccess(responseBasicInformation);
            }

            @Override
            public void loadBaseInformationDatasFailed(Exception e) {
                fitmentLiveView.loadBaseInformationDatasFailed(e);
            }
        });
        fitmentLiveModel.loadFitmentProgressDatas(progressId, buildingId, nextPage, pageSize, new FitmentLiveModel.CallbackFitmentProgress() {
            @Override
            public void loadFitmentProgressSuccess(ResponseFitmentPorgress responseFitmentPorgress) {
                ResponseFitmentPorgress.PageInfoBean pageInfo = responseFitmentPorgress.getPageInfo();
                if (pageInfo.getPageTotalNum() - pageInfo.getPageSize() * (pageInfo.getPageNo() + 1) <= 0)
                    fitmentLiveView.noMoreData();
                fitmentLiveView.loadFitmentProgressSuccess(responseFitmentPorgress);
                nextPage++;
            }

            @Override
            public void loadFitmentProgressFailed(Exception e) {
                fitmentLiveView.loadFitmentProgressFailed(e);
            }
        });
    }

    @Override
    public void reLoadDatas(String progressId, String buildingId) {
        nextPage = 0;
        loadDatas(progressId, buildingId);
    }
}
