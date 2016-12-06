package com.bwf.aiyiqi.mvp.modle.impl;

import com.bwf.aiyiqi.mvp.modle.OnePageModle;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/6.
 */

public class DetailModleImpl implements OnePageModle {
    @Override
    public void loadDatas(String url, final CallBack callBack) {
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
