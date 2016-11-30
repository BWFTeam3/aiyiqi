package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseCityEvent;

/**
 * Created by Administrator on 2016/11/30.
 */

public interface CityEventView {
    void loadDatasSuccess(ResponseCityEvent responseCityEvent);
    void loadDatasFailed(Exception e);
    void noMoreData();
}
