package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseBuilding;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface BuildingView {
    void showResposeSuccess(ResponseBuilding data);
    void ShowFailed();
    void ShowNoMoreData();
}
