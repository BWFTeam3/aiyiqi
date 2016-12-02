package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseCityEvent;
import com.bwf.aiyiqi.mvp.modle.CityEventModel;
import com.bwf.aiyiqi.mvp.modle.impl.CityEventModelImpl;
import com.bwf.aiyiqi.mvp.presenter.CityEventPresenter;
import com.bwf.aiyiqi.mvp.view.CityEventView;

/**
 * Created by Administrator on 2016/11/30.
 */

public class CityEventPresenterImpl implements CityEventPresenter {
    private CityEventModel cityEventModel;
    private CityEventView cityEventView;
    private int page = 0;
    private final int pageSize = 10;

    public CityEventPresenterImpl(CityEventView cityEventView) {
        this.cityEventModel = new CityEventModelImpl();
        this.cityEventView = cityEventView;
    }

    @Override
    public void loadDatas() {
        cityEventModel.loadDatas(page, pageSize, new CityEventModel.Callback() {
            @Override
            public void loadSuccess(ResponseCityEvent responseCityEvent) {
                if (responseCityEvent.getCurrentPage() * responseCityEvent.getData().getForumlist().size() >= responseCityEvent.getTotalCount())
                    cityEventView.noMoreData();
                cityEventView.loadDatasSuccess(responseCityEvent);
            }

            @Override
            public void loadFailed(Exception e) {
                cityEventView.loadDatasFailed(e);
            }
        });
    }

    @Override
    public void reloadDatas() {
        page = 0;
        loadDatas();
    }
}
