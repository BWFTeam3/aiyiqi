package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseNewest;
import com.bwf.aiyiqi.mvp.modle.NewestModel;
import com.bwf.aiyiqi.mvp.modle.impl.NewestModelImpl;
import com.bwf.aiyiqi.mvp.presenter.Newestpresenter;
import com.bwf.aiyiqi.mvp.view.NewestView;

/**
 * Created by Administrator on 2016/12/5.
 */

public class NewestpresenterImpl implements Newestpresenter {
    private NewestModel newestModel;
    private NewestView newestView;
    private final String cityName = "成都";
    private final int pageSize = 10;
    private int page = 1;

    public NewestpresenterImpl(NewestView newestView) {
        this.newestModel = new NewestModelImpl();
        this.newestView = newestView;
    }

    @Override
    public void loadDatas() {
        newestModel.loadDatas(cityName, page, pageSize, new NewestModel.Callback() {
            @Override
            public void loadDatasSuccess(ResponseNewest responseNewest) {
                if (responseNewest.getCurrentPage() * pageSize >= responseNewest.getTotalCount())
                    newestView.noMoreData();
                newestView.loadDatasSuccess(responseNewest);
                page++;
            }

            @Override
            public void loadDatasFailed(Exception e) {
                newestView.loadDatasFailed(e);
            }
        });
    }

    @Override
    public void reLoadDatas() {
        page = 1;
        loadDatas();
    }
}
