package com.bwf.aiyiqi.mvp.modle;

import com.bwf.aiyiqi.entity.ResponseFitmentLive;
import com.bwf.aiyiqi.entity.ResponseFlashView;

/**
 * Created by Administrator on 2016/11/23.
 */

public interface DecorationCompanyModel {
    void loadDatasFlashView(CallbackFlashView callbackFlashView);
    interface CallbackFlashView{
        void loadSuccess(ResponseFlashView responseFlashView);
        void loadFailed(Exception e);
    }
    void loadDatasFitmentLive(CallbackFitmentLive callbackFitmentLive);
    interface CallbackFitmentLive{
        void loadSuccess(ResponseFitmentLive responseFitmentLive);
        void loadFailed(Exception e);
    }
}
