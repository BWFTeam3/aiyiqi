package com.bwf.aiyiqi.mvp.modle.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseFitmentLive;
import com.bwf.aiyiqi.entity.ResponseFlashView;
import com.bwf.aiyiqi.framwork.Apis;
import com.bwf.aiyiqi.mvp.modle.DecorationCompanyModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/23.
 */

public class DecorationCompanyModelImpl implements DecorationCompanyModel {

    @Override
    public void loadDatasFlashView(final CallbackFlashView callbackFlashView) {
        OkHttpUtils.get().url(Apis.URL_FLASHVIEW).build().execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callbackFlashView.loadFailed(e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ResponseFlashView responseFlashView = JSON.parseObject(response, ResponseFlashView.class);
                        callbackFlashView.loadSuccess(responseFlashView);
                    }
                });
    }

    @Override
    public void loadDatasFitmentLive(final CallbackFitmentLive callbackFitmentLive) {
        OkHttpUtils.get().url(Apis.URL_FITMENT_LIVE).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callbackFitmentLive.loadFailed(e);
            }

            @Override
            public void onResponse(String response, int id) {
                ResponseFitmentLive responseFitmentLive = JSON.parseObject(response, ResponseFitmentLive.class);
                callbackFitmentLive.loadSuccess(responseFitmentLive);
            }
        });
    }
}
