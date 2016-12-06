package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseElite;
import com.bwf.aiyiqi.mvp.modle.EliteModel;
import com.bwf.aiyiqi.mvp.modle.impl.EliteModelImpl;
import com.bwf.aiyiqi.mvp.presenter.ElitePresenter;
import com.bwf.aiyiqi.mvp.view.EliteView;

/**
 * Created by Administrator on 2016/12/4.
 */

public class ElitePresenterImpl implements ElitePresenter {
    private EliteModel eliteModel;
    private EliteView eliteView;
    private int page = 1;
    private final int pageSize = 10;

    public ElitePresenterImpl(EliteView eliteView) {
        this.eliteModel = new EliteModelImpl();
        this.eliteView = eliteView;
    }

    @Override
    public void loadDatas() {
        eliteModel.loadDatas(page, pageSize, new EliteModel.Callback() {
            @Override
            public void loadDatasSuccess(ResponseElite responseElite) {
                if (responseElite.getCurrentPage() * pageSize >= responseElite.getTotalCount())
                    eliteView.noMoreData();
                eliteView.loadSuccess(responseElite);
                page++;
            }

            @Override
            public void loadDatasFailed(Exception e) {
                eliteView.loadFailed(e);
            }
        });
    }

    @Override
    public void reLoadDatas() {
        page = 1;
        loadDatas();
    }
}
