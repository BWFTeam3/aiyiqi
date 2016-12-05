package com.bwf.aiyiqi.mvp.modle.impl;

import com.bwf.aiyiqi.mvp.modle.DesignModle;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Phyj on 2016/12/3.
 */

public class DesignModleImpl implements DesignModle {

    @Override
    public void loadDatas(String url, final DesignTopicCallBack callBack) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callBack.onFaild(e);
            }

            @Override
            public void onResponse(String response, int id) {
                callBack.onSuccess(response);
            }
        });
    }

    @Override
    public void loadNextDatas(String url, final DesignTopicCallBack callBack) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callBack.onFaild(e);
            }

            @Override
            public void onResponse(String response, int id) {
                callBack.onSuccess(response);
            }
        });
    }
}
