package com.bwf.aiyiqi.mvp.presenter;

/**
 * Created by Administrator on 2016/11/28.
 */

public interface FitmentPresenter {
    void loadTags(int stage);
    void loadNews(int stage,String tag);
    void loadNextNews(int stage,String tag);
}
