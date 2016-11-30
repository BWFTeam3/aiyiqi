package com.bwf.aiyiqi.mvp.modle.impl;

import com.bwf.aiyiqi.mvp.modle.SearchModle;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/29.
 */

public class SearchModleImpl implements SearchModle {
    @Override
    public void loadDatas(String url, final SearchCallback searchCallback) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                searchCallback.onFaild(e);
            }

            @Override
            public void onResponse(String response, int id) {
                searchCallback.onSuccess(response);
            }
        });
    }

    @Override
    public void loadNextPage(String url, final SearchCallback searchCallback) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                searchCallback.onFaild(e);
            }

            @Override
            public void onResponse(String response, int id) {
                searchCallback.onSuccess(response);
            }
        });
    }
}
