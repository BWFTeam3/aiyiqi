package com.bwf.aiyiqi.mvp.view;

/**
 * Created by Administrator on 2016/11/24.
 */

public interface MainRecycleView {
    void showMainSuccess(String response);
    void showMainFaild(Exception e);
    void showMainPagersSuccess(String response);
    void showMainPagersFaild(Exception e);
}
