package com.bwf.aiyiqi.mvp.presenter.Impl;

import android.util.Log;

import com.bwf.aiyiqi.mvp.modle.OnePageModle;
import com.bwf.aiyiqi.mvp.modle.impl.DetailModleImpl;
import com.bwf.aiyiqi.mvp.presenter.ArticlePresenter;
import com.bwf.aiyiqi.mvp.view.ArticleView;
import com.bwf.aiyiqi.utils.Apis;
import com.bwf.aiyiqi.utils.UrlHandler;

/**
 * Created by Administrator on 2016/12/6.
 */

public class ArticlePresenterImpl implements ArticlePresenter {
    private OnePageModle modle;
    private ArticleView view;

    public ArticlePresenterImpl(ArticleView view) {
        this.view = view;
        modle = new DetailModleImpl();
    }

    @Override
    public void loadDatas(String id) {
        String url= UrlHandler.handlUrl(Apis.ARTICLES,id);
        modle.loadDatas(url, new OnePageModle.CallBack() {
            @Override
            public void onSuccess(String response) {
                view.showDatasSuccess(response);
            }

            @Override
            public void onFaild(Exception e) {
                view.showDatasFaild(e);
            }
        });
    }

    @Override
    public void loadReplys(String id) {
        String url= UrlHandler.handlUrl(Apis.ARTICLESREPLYS,id);
        modle.loadDatas(url, new OnePageModle.CallBack() {
            @Override
            public void onSuccess(String response) {
                view.showReplysSuccess(response);
            }

            @Override
            public void onFaild(Exception e) {
                view.showReplysFaild(e);
            }
        });
    }
}
