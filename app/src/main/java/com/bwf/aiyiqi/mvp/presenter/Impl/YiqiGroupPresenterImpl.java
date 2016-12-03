package com.bwf.aiyiqi.mvp.presenter.Impl;

import com.bwf.aiyiqi.entity.ResponseYiqiGroup;
import com.bwf.aiyiqi.mvp.modle.YiqiGroupModel;
import com.bwf.aiyiqi.mvp.modle.impl.YiqiGroupModelImpl;
import com.bwf.aiyiqi.mvp.presenter.YiqiGroupPresenter;
import com.bwf.aiyiqi.mvp.view.YiqiGroupView;

/**
 * Created by Administrator on 2016/11/25.
 */

public class YiqiGroupPresenterImpl implements YiqiGroupPresenter {
    private YiqiGroupModel yiqiGroupModel;
    private YiqiGroupView yiqiGroupView;
    private int nextPage = 0;
    private final String pageSize = "10";
    public YiqiGroupPresenterImpl(YiqiGroupView yiqiGroupView) {
        this.yiqiGroupModel = new YiqiGroupModelImpl();
        this.yiqiGroupView = yiqiGroupView;
    }

    @Override
    public void loadDatas(String type) {
        yiqiGroupModel.loadDatas(type,nextPage,pageSize,new YiqiGroupModel.Callback() {
            @Override
            public void loadSuccess(ResponseYiqiGroup responseYiqiGroup) {
                yiqiGroupView.loadSuccess(responseYiqiGroup);
            }

            @Override
            public void loadFailed(Exception e) {
                yiqiGroupView.loadFailed(e);
                nextPage--;
            }

            @Override
            public void noMoreData() {
                yiqiGroupView.noMoreData();
            }
        });
        nextPage++;
    }

    @Override
    public void reLoadDatas(String type) {
        nextPage = 0;
        loadDatas(type);
    }
}
