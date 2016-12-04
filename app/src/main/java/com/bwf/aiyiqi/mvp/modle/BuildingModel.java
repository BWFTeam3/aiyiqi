package com.bwf.aiyiqi.mvp.modle;

import com.bwf.aiyiqi.entity.ResponseBuilding;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface BuildingModel {
    void loadDatas(Callback callback);
    public interface Callback{
        void loadDataSuccess(ResponseBuilding data);
        void loadDataFailed();
    }
}
