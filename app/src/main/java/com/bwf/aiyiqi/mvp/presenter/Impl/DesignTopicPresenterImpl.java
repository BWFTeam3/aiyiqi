package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.mvp.modle.DesignModle;
import com.bwf.aiyiqi.mvp.modle.impl.DesignModleImpl;
import com.bwf.aiyiqi.mvp.presenter.DesignTopicPresenter;
import com.bwf.aiyiqi.mvp.view.DesignView;
import com.bwf.aiyiqi.utils.Apis;
import com.bwf.aiyiqi.utils.UrlHandler;

/**
 * Created by Phyj on 2016/12/3.
 */

public class DesignTopicPresenterImpl implements DesignTopicPresenter {
    private DesignView view;
    private DesignModle modle;
    private int nextPage;
    public DesignTopicPresenterImpl(DesignView view) {
        this.view = view;
        modle = new DesignModleImpl();
    }

    @Override
    public void loadDatas() {
        nextPage=1;
        String url = UrlHandler.handlUrl(Apis.DESIGNTOPIC,nextPage);
        modle.loadDatas(url, new DesignModle.DesignTopicCallBack() {
            @Override
            public void onSuccess(String response) {
                view.showSuccess(response);
                nextPage++;
            }

            @Override
            public void onFaild(Exception e) {
                view.showFaild(e);
            }
        });
    }

    @Override
    public void loadNextDatas() {
        String url = UrlHandler.handlUrl(Apis.DESIGNTOPIC,nextPage);
        modle.loadDatas(url, new DesignModle.DesignTopicCallBack() {
            @Override
            public void onSuccess(String response) {
                view.showNextSuccess(response);
                nextPage++;
            }

            @Override
            public void onFaild(Exception e) {
                view.showNextFaild(e);
            }
        });
    }
}
