package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.mvp.modle.FitmentModle;
import com.bwf.aiyiqi.mvp.modle.impl.FitmentModleImpl;
import com.bwf.aiyiqi.mvp.presenter.FitmentPresenter;
import com.bwf.aiyiqi.mvp.view.FitmentView;
import com.bwf.aiyiqi.utils.Apis;
import com.bwf.aiyiqi.utils.UrlHandler;

/**
 * Created by Administrator on 2016/11/28.
 */

public class FitmentPresenterImpl implements FitmentPresenter {
    private FitmentModle modle;
    private FitmentView view;
    private int nextPage=1;

    public FitmentPresenterImpl(FitmentView view) {
        this.view = view;
        this.modle=new FitmentModleImpl();
    }

    @Override
    public void loadTags(int tag) {
        String url= UrlHandler.handlUrl(Apis.FITTAG,tag);
        modle.loadTags(url, new FitmentModle.CallBack() {
            @Override
            public void onSuccess(String response) {
                view.showTagsSuccess(response);
            }

            @Override
            public void onFaild(Exception e) {
                view.showTagsFaild(e);

            }
        });
    }

    @Override
    public void loadNews(int stage,String tag) {
        nextPage=1;
        String url1=UrlHandler.handlUrl(Apis.FITNEWS,tag,nextPage);
        modle.loadNews(url1, new FitmentModle.CallBack() {
            @Override
            public void onSuccess(String response) {
                view.showNewsSuccess(response);

            }

            @Override
            public void onFaild(Exception e) {
                view.showNewsFaild(e);
            }
        });
    }

    @Override
    public void loadNextNews(int stage,String tag) {
        String url1=UrlHandler.handlUrl(Apis.FITNEWS,tag,nextPage);
        modle.loadNews(url1, new FitmentModle.CallBack() {
            @Override
            public void onSuccess(String response) {
                view.showNewsSuccess(response);
                nextPage++;
            }
            @Override
            public void onFaild(Exception e) {
                view.showNewsFaild(e);
            }
        });
    }
}
