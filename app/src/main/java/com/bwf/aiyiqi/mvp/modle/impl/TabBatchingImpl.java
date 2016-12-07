package com.bwf.aiyiqi.mvp.modle.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.TabBatchingData;
import com.bwf.aiyiqi.mvp.modle.TabBatching;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/24.
 */

public class TabBatchingImpl implements TabBatching {
    String url ="http://appapi.17house.com/GrouponApi.php?version=1&action=getSingleSupplementInfo&cityId=2&model=android&app_version=android_com.aiyiqi.galaxy_1.1";
    public void LoadTabBatching(final TabBatchingLoadingCallBack callBack) {

        OkHttpUtils.get().url(url)
                .build()
                .execute(new StringCallback(){

                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("TabBatchingImpl", response);
                        TabBatchingData tabBatchingData = JSON.parseObject(response,TabBatchingData.class);
                        callBack.LoadSuccess(tabBatchingData);
                    }
                });
}
}

