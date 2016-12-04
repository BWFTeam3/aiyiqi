package com.bwf.aiyiqi.mvp.modle;

/**
 * Created by Phyj on 2016/12/3.
 */

public interface DesignModle {
    void loadDatas(String url, DesignTopicCallBack callBack);

    void loadNextDatas(String url, DesignTopicCallBack callBack);

    interface DesignTopicCallBack {
        void onSuccess(String response);

        void onFaild(Exception e);
    }
}
