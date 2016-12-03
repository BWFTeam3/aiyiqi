package com.bwf.aiyiqi.mvp.modle.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseCityEvent;
import com.bwf.aiyiqi.mvp.modle.CityEventModel;
import com.bwf.aiyiqi.utils.Apis;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/30.
 */

public class CityEventModelImpl implements CityEventModel {
    @Override
    public void loadDatas(int page, int pageSize, final Callback callback) {
        OkHttpUtils.post()
                .addParams("page", page + "")
                .addParams("pageSize", pageSize + "")
                .url(Apis.URL_CITY_EVENT)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callback.loadFailed(e);
            }

            @Override
            public void onResponse(String response, int id) {
                ResponseCityEvent responseCityEvent = JSON.parseObject(response, ResponseCityEvent.class);
                callback.loadSuccess(responseCityEvent);
            }
        });
    }
}
