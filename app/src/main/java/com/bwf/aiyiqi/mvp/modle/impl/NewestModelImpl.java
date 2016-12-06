package com.bwf.aiyiqi.mvp.modle.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseNewest;
import com.bwf.aiyiqi.mvp.modle.NewestModel;
import com.bwf.aiyiqi.utils.Apis;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/4.
 */

public class NewestModelImpl implements NewestModel {
    @Override
    public void loadDatas(String cityName, int page, int pageSize, final Callback callback) {
        OkHttpUtils.post()
                .addParams("a", "allThread")
                .addParams("c", "forumThreadList")
                .addParams("uuid", "86305803367590")
                .addParams("pageSize",pageSize+"")
                .addParams("cityName",cityName)
                .addParams("m", "forum")
                .addParams("page",page+"")
                .addParams("haspermission", "yes")
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
                ResponseNewest responseNewest = JSON.parseObject(response, ResponseNewest.class);
                callback.loadDatasSuccess(responseNewest);
            }
        });

    }
}
