package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseFitmentLive;
import com.bwf.aiyiqi.entity.ResponseFlashView;

/**
 * Created by Administrator on 2016/11/23.
 */

public interface DecorationCompanyView {
    void loadFlashViewSuccess(ResponseFlashView responseFlashView);
    void loadFlashViewFailed(Exception e);
    void loadFitmentLiveSuccess(ResponseFitmentLive responseFitmentLive);
    void loadFitmentLiveFailed(Exception e);
}
