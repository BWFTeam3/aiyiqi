package com.bwf.aiyiqi.mvp.modle;

import com.bwf.aiyiqi.entity.ResponseCityEvent;

/**
 * Created by Administrator on 2016/11/30.
 */

public interface CityEventModel {
    void loadDatas(int page,int pageSize,Callback callback);

    interface Callback {
        void loadSuccess(ResponseCityEvent responseCityEvent);

        void loadFailed(Exception e);
    }
}
