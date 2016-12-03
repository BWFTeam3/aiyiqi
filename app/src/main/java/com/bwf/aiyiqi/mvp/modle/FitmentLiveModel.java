package com.bwf.aiyiqi.mvp.modle;

import com.bwf.aiyiqi.entity.ResponseBasicInformation;
import com.bwf.aiyiqi.entity.ResponseFitmentPorgress;

/**
 * Created by Administrator on 2016/11/27.
 */

public interface FitmentLiveModel {
    void loadBaseInformationDatas(String buildingId, CallbcakBaseInformation callbcakBaseInformation);
    interface CallbcakBaseInformation{
        void loadBaseInformationDatasSuccess(ResponseBasicInformation responseBasicInformation);
        void loadBaseInformationDatasFailed(Exception e);
    }
    void loadFitmentProgressDatas(String progressId, String buildingId, int page, int pageSize, CallbackFitmentProgress callbackFitmentProgress);
    interface CallbackFitmentProgress{
        void loadFitmentProgressSuccess(ResponseFitmentPorgress responseFitmentPorgress);
        void loadFitmentProgressFailed(Exception e);
    }
}