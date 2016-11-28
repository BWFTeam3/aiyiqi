package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.mvp.modle.MainRecycleModle;
import com.bwf.aiyiqi.mvp.modle.impl.MainRecycleModleImpl;
import com.bwf.aiyiqi.mvp.presenter.MainRecyclePresenter;
import com.bwf.aiyiqi.mvp.view.MainRecycleView;
import com.bwf.aiyiqi.utils.Apis;
import com.bwf.aiyiqi.utils.UrlHandler;

/**
 * Created by Administrator on 2016/11/24.
 */

public class MainRecyclePresenterImpl implements MainRecyclePresenter {
    private MainRecycleView view;
    private MainRecycleModle modle;
    private int nestPage=2;

    public MainRecyclePresenterImpl(MainRecycleView view) {
        this.view = view;
        modle=new MainRecycleModleImpl();
    }

    @Override
    public void loadDatas() {
        modle.loadDatas(Apis.ARTICLE, new MainRecycleModle.MainRecycleCallBack() {
            @Override
            public void onSuccess(String response) {
                view.showMainSuccess(response);
            }

            @Override
            public void onFaild(Exception e) {
                view.showMainFaild(e);
            }
        });

        modle.loadPagers(Apis.AUTOPAGER, new MainRecycleModle.MainRecycleCallBack() {
            @Override
            public void onSuccess(String response) {
                view.showMainPagersSuccess(response);
            }

            @Override
            public void onFaild(Exception e) {
                view.showMainPagersFaild(e);
            }
        });
    }

    @Override
    public void loadNextPage(int type, String id) {
        String url= UrlHandler.handlUrl(Apis.NEXTARTICLE,nestPage,type,id);
        modle.loadDatas(url, new MainRecycleModle.MainRecycleCallBack() {
            @Override
            public void onSuccess(String response) {
                view.showMainSuccess(response);
                nestPage++;
            }

            @Override
            public void onFaild(Exception e) {
                view.showMainFaild(e);
            }
        });
    }


}
