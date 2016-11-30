package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseBasicInformation;
import com.bwf.aiyiqi.entity.ResponseFitmentPorgress;

/**
 * Created by Administrator on 2016/11/27.
 */

public interface FitmentLiveView {
    void loadBaseInformationDatasSuccess(ResponseBasicInformation responseBasicInformation);

    void loadBaseInformationDatasFailed(Exception e);

    void loadFitmentProgressSuccess(ResponseFitmentPorgress responseFitmentPorgress);

    void loadFitmentProgressFailed(Exception e);

    void noMoreData();
}
