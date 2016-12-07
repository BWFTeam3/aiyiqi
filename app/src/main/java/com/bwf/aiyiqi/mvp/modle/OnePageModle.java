package com.bwf.aiyiqi.mvp.modle;

/**
 * Created by Administrator on 2016/12/6.
 */

public interface OnePageModle {
    void loadDatas(String url,CallBack callBack);
    interface CallBack{
        void onSuccess(String response);
        void onFaild(Exception e);
    }
}
