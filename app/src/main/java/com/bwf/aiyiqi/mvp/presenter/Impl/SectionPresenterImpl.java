package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseSection;
import com.bwf.aiyiqi.mvp.modle.SectionModel;
import com.bwf.aiyiqi.mvp.modle.impl.SectionModelImpl;
import com.bwf.aiyiqi.mvp.presenter.SectionPresenter;
import com.bwf.aiyiqi.mvp.view.SectionView;

/**
 * Created by Administrator on 2016/12/5.
 */

public class SectionPresenterImpl implements SectionPresenter {
    private SectionModel sectionModel;
    private SectionView sectionView;
    private final String cityName = "成都";
    private final String cityId = "2";
    public SectionPresenterImpl(SectionView sectionView) {
        this.sectionView = sectionView;
        this.sectionModel = new SectionModelImpl();
    }

    @Override
    public void loadDatas() {
        sectionModel.loadDatas(cityName, cityId, new SectionModel.Callback() {
            @Override
            public void loadDatasSuccess(ResponseSection responseSection) {
                sectionView.loadDatasSuccess(responseSection);
            }

            @Override
            public void loadDatasFailed(Exception e) {
                sectionView.loadDatasFailed(e);
            }
        });
    }
}
