package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.mvp.modle.SearchModle;
import com.bwf.aiyiqi.mvp.modle.impl.SearchModleImpl;
import com.bwf.aiyiqi.mvp.presenter.SearchPresenter;
import com.bwf.aiyiqi.mvp.view.SearchView;
import com.bwf.aiyiqi.utils.Apis;
import com.bwf.aiyiqi.utils.UrlHandler;

/**
 * Created by Administrator on 2016/11/29.
 */

public class SearchPresenterImpl implements SearchPresenter {
    private SearchModle modle;
    private SearchView view;

    public SearchPresenterImpl(SearchView view) {
        this.view = view;
        modle=new SearchModleImpl();
    }

    @Override
    public void loadDatas(String content) {
        nextpage=1;
        String url= UrlHandler.handlUrl(Apis.SEARCH,nextpage,content);
        modle.loadDatas(url, new SearchModle.SearchCallback() {
            @Override
            public void onSuccess(String response) {
                view.showSeachSuccess(response);
            }

            @Override
            public void onFaild(Exception e) {
                view.showSeachFaild(e);
            }
        });
    }
    private int nextpage=1;
    @Override
    public void loadNextPage(String content) {
        String url= UrlHandler.handlUrl(Apis.SEARCH,nextpage,content);
        modle.loadNextPage(url, new SearchModle.SearchCallback() {
            @Override
            public void onSuccess(String response) {
                view.showSeachSuccess(response);
                nextpage++;
            }

            @Override
            public void onFaild(Exception e) {
                view.showSeachFaild(e);
            }
        });
    }
}
