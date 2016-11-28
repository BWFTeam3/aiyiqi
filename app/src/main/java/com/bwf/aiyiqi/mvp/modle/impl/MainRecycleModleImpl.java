package com.bwf.aiyiqi.mvp.modle.impl;

import com.bwf.aiyiqi.mvp.modle.MainRecycleModle;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/24.
 */

public class MainRecycleModleImpl implements MainRecycleModle {
    @Override
    public void loadDatas(String url, final MainRecycleCallBack mainRecycleCallBack) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                mainRecycleCallBack.onFaild(e);
            }

            @Override
            public void onResponse(String response, int id) {
                mainRecycleCallBack.onSuccess(response);
            }
        });
    }

    @Override
    public void loadPagers(String url, final MainRecycleCallBack mainRecycleCallBack) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                mainRecycleCallBack.onFaild(e);
            }

            @Override
            public void onResponse(String response, int id) {
                mainRecycleCallBack.onSuccess(response);
            }
        });
    }
}
