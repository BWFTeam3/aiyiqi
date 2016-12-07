package com.bwf.aiyiqi.mvp.view;

/**
 * Created by Administrator on 2016/12/6.
 */

public interface ArticleView {
    void showDatasSuccess(String response);
    void showDatasFaild(Exception e);
    void showReplysSuccess(String response);
    void showReplysFaild(Exception e);
}
