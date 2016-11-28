package com.bwf.aiyiqi.mvp.modle;

/**
 * Created by Administrator on 2016/11/24.
 */

public interface MainRecycleModle {
    void loadDatas(String url,MainRecycleCallBack mainRecycleCallBack);
    void loadPagers(String url,MainRecycleCallBack mainRecycleCallBack);
    interface MainRecycleCallBack{
        void onSuccess(String response);
        void onFaild(Exception e);
    }

}
