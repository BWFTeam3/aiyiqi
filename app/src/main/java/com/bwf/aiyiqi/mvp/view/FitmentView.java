package com.bwf.aiyiqi.mvp.view;

/**
 * Created by Administrator on 2016/11/28.
 */

public interface FitmentView {
    void showTagsSuccess(String response);
    void showTagsFaild(Exception e);
    void showNewsSuccess(String response);
    void showNewsFaild(Exception e);
    void showNextSuccess(String response);
    void showNextFaild(Exception e);
}
