package com.bwf.aiyiqi.mvp.modle.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseSection;
import com.bwf.aiyiqi.mvp.modle.SectionModel;
import com.bwf.aiyiqi.utils.Apis;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/5.
 */

public class SectionModelImpl implements SectionModel {
    @Override
    public void loadDatas(String cityName, String cityId, final Callback callback) {
        OkHttpUtils.post()
                .addParams("a", "miscForum")
                .addParams("uuid", "86305803367590")
                .addParams("cityName", cityName)
                .addParams("m", "misc")
                .addParams("haspermission", "yes")
                .addParams("cityId", cityId)
                .addParams("model", "android")
                .addParams("sessionToken", "")
                .addParams("app_version", "android_com.aiyiqi.galaxy_1.1")
                .url(Apis.URL_OWNER_TALK)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callback.loadDatasFailed(e);
            }

            @Override
            public void onResponse(String response, int id) {
                ResponseSection responseSection = JSON.parseObject(response, ResponseSection.class);
                callback.loadDatasSuccess(responseSection);
            }
        });
    }
}
