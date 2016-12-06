package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.mvp.modle.DesignModle;
import com.bwf.aiyiqi.mvp.modle.impl.DesignModleImpl;
import com.bwf.aiyiqi.mvp.presenter.DesignPsPresenter;
import com.bwf.aiyiqi.mvp.view.DesignView;
import com.bwf.aiyiqi.utils.Apis;
import com.bwf.aiyiqi.utils.UrlHandler;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Phyj on 2016/12/3.
 */

public class DesignPsPresenterImpl implements DesignPsPresenter {
    private DesignView view;
    private DesignModle modle;
    private int nextPage;
    private Map<String,String> map;
    public DesignPsPresenterImpl(DesignView view) {
        this.view = view;
        modle = new DesignModleImpl();
    }

    @Override
    public void loadDatas(Map<String,String> map) {
        nextPage=1;
        StringBuffer str=new StringBuffer();
        if (map.size()==0){
            str.append("0");
        }else{
            Iterator<String> iterator = map.keySet().iterator();
            while(iterator.hasNext()){
                str.append(iterator.next());
            }
        }
        String url = UrlHandler.handlUrl(Apis.DESIGNPS,nextPage,str.toString());
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
    public void loadNextDatas(Map<String,String> map) {
        StringBuffer str=new StringBuffer();
        if (map.size()==0){
            str.append("0");
        }else{
            Iterator<String> iterator = map.keySet().iterator();
            while(iterator.hasNext()){
                str.append(iterator.next());
            }
        }
        String url = UrlHandler.handlUrl(Apis.DESIGNPS,nextPage,str);
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
