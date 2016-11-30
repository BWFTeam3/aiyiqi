package com.bwf.aiyiqi.mvp.modle.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseYiqiGroup;
import com.bwf.aiyiqi.mvp.modle.YiqiGroupModel;
import com.bwf.aiyiqi.utils.Apis;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/25.
 */

public class YiqiGroupModelImpl implements YiqiGroupModel {
    @Override
    public void loadDatas(String type,int pageNo,String pageSize, final Callback callback) {
        OkHttpUtils.post()
                .addParams("token","DAB088BA50C9405E84C789055D657614")
                .addParams("app_version","android_com.aiyiqi.galaxy_1.1")
                .addParams("type",type)
                .addParams("haspermission","yes")
                .addParams("pageNo",pageNo+"")
                .addParams("pageSize",pageSize)
                .url(Apis.URL_YIQIGROUP).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callback.loadFailed(e);
            }

            @Override
            public void onResponse(String response, int id) {
                ResponseYiqiGroup responseYiqiGroup = JSON.parseObject(response, ResponseYiqiGroup.class);
                if (responseYiqiGroup.getData().size() == 0) {
                    callback.noMoreData();
                    return;
                }
                if (responseYiqiGroup.getPageInfo().getPageSize() > responseYiqiGroup.getData().size())
                    callback.noMoreData();
                callback.loadSuccess(responseYiqiGroup);
            }
        });
    }
}
