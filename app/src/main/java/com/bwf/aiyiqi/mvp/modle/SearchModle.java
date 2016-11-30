package com.bwf.aiyiqi.mvp.modle;

/**
 * Created by Administrator on 2016/11/29.
 */

public interface SearchModle {
    void loadDatas(String url,SearchCallback searchCallback);
    void loadNextPage(String url,SearchCallback searchCallback);
    interface SearchCallback{
        void onSuccess(String response);
        void onFaild(Exception e);
    }
}
