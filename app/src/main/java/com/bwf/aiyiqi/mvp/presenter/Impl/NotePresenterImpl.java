package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.mvp.modle.OnePageModle;
import com.bwf.aiyiqi.mvp.modle.impl.DetailModleImpl;
import com.bwf.aiyiqi.mvp.presenter.NotePresenter;
import com.bwf.aiyiqi.mvp.view.NoteView;
import com.bwf.aiyiqi.utils.Apis;
import com.bwf.aiyiqi.utils.UrlHandler;

/**
 * Created by Administrator on 2016/12/6.
 */

public class NotePresenterImpl implements NotePresenter {
    private OnePageModle modle;
    private NoteView view;

    public NotePresenterImpl(NoteView view) {
        this.view = view;
        modle = new DetailModleImpl();
    }

    @Override
    public void loadDatas(String id) {
        String url= UrlHandler.handlUrl(Apis.NOTES,id);
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
        String url= UrlHandler.handlUrl(Apis.NOTESREPLYS,id);
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

    @Override
    public void loadLikes(String id) {
        String url= UrlHandler.handlUrl(Apis.NOTESLIKES,id);
        modle.loadDatas(url, new OnePageModle.CallBack() {
            @Override
            public void onSuccess(String response) {
                view.showLikesSuccess(response);
            }

            @Override
            public void onFaild(Exception e) {
                view.showLikesFaild(e);
            }
        });
    }

}
