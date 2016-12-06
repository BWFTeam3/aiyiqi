package com.bwf.aiyiqi.mvp.modle.impl;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseBuilding;
import com.bwf.aiyiqi.mvp.modle.BuildingModel;
import com.bwf.aiyiqi.utils.Apis;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by 11645 on 2016/12/4.
 */

public class BuildingModelImpl implements BuildingModel {
    @Override
    public void loadDatas(final Callback callback) {
        OkHttpUtils.post()
                .url(Apis.BUILDING)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadDataFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if(TextUtils.isEmpty(response))return;
                        ResponseBuilding data = JSON.parseObject
                                (response,ResponseBuilding.class);
                        if(data != null){
                            callback.loadDataSuccess(data);
                        }
                    }
                });
    }
}
