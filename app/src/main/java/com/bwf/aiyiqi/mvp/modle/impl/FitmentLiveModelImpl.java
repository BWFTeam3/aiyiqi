package com.bwf.aiyiqi.mvp.modle.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseBasicInformation;
import com.bwf.aiyiqi.entity.ResponseFitmentPorgress;
import com.bwf.aiyiqi.mvp.modle.FitmentLiveModel;
import com.bwf.aiyiqi.utils.Apis;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/27.
 */

public class FitmentLiveModelImpl implements FitmentLiveModel {

    @Override
    public void loadBaseInformationDatas(String buildingId, final CallbcakBaseInformation callbcakBaseInformation) {
        OkHttpUtils.post()
                .addParams("token", "DAB088BA50C9405E84C789055D657614")
                .addParams("app_version", "android_com.aiyiqi.galaxy_1.1")
                .addParams("buildingId", buildingId)
                .url(Apis.URL_SITE_PLAYING_BASIC_INFORMATION).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callbcakBaseInformation.loadBaseInformationDatasFailed(e);
            }

            @Override
            public void onResponse(String response, int id) {
                ResponseBasicInformation responseBasicInformation = JSON.parseObject(response, ResponseBasicInformation.class);
                callbcakBaseInformation.loadBaseInformationDatasSuccess(responseBasicInformation);
            }
        });
    }

    @Override
    public void loadFitmentProgressDatas(String progressId, String buildingId, int page, int pageSize, final CallbackFitmentProgress callbackFitmentProgress) {
        OkHttpUtils.post()
                .addParams("progressId", progressId)
                .addParams("app_version", "android_com.aiyiqi.galaxy_1.1")
                .addParams("buildingId", buildingId)
                .addParams("page", page + "")
                .addParams("pageSize", pageSize + "")
                .url(Apis.URL_FITMENT_PROGRESS)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callbackFitmentProgress.loadFitmentProgressFailed(e);
            }

            @Override
            public void onResponse(String response, int id) {
                ResponseFitmentPorgress responseFitmentPorgress = JSON.parseObject(response, ResponseFitmentPorgress.class);
                callbackFitmentProgress.loadFitmentProgressSuccess(responseFitmentPorgress);
            }
        });

    }
}
