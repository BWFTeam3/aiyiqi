package com.bwf.aiyiqi.mvp.modle.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseElite;
import com.bwf.aiyiqi.mvp.modle.EliteModel;
import com.bwf.aiyiqi.utils.Apis;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/4.
 */

public class EliteModelImpl implements EliteModel {
    @Override
    public void loadDatas(int page, int pageSize, final Callback callback) {
        OkHttpUtils.post()
                .addParams("page", page + "")
                .addParams("pageSize", pageSize + "")
                .addParams("a", "allThread")
                .addParams("c", "forumThreadList")
                .addParams("mode", "digest")
                .addParams("uuid", "86305803367590")
                .addParams("m", "forum")
                .addParams("haspermission", "yes")
                .addParams("model", "android")
                .addParams("app_version", "android_com.aiyiqi.galaxy_1.1")
                .addParams("sessionToken", "")
                .url(Apis.URL_OWNER_TALK)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callback.loadDatasFailed(e);
            }

            @Override
            public void onResponse(String response, int id) {
                ResponseElite responseElite = JSON.parseObject(response, ResponseElite.class);
                callback.loadDatasSuccess(responseElite);
            }
        });
    }
}
