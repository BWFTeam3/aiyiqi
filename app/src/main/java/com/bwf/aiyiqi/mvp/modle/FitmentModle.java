package com.bwf.aiyiqi.mvp.modle;

/**
 * Created by Administrator on 2016/11/28.
 */

public interface FitmentModle {
    void loadTags(String url,CallBack callBack);
    void loadNews(String url,CallBack callBack);
    interface CallBack {
        void onSuccess(String response);
        void onFaild(Exception e);
    }
}
