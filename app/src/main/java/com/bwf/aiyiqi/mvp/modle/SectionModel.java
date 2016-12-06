package com.bwf.aiyiqi.mvp.modle;

import com.bwf.aiyiqi.entity.ResponseSection;

/**
 * Created by Administrator on 2016/12/5.
 */

public interface SectionModel {
    void loadDatas(String cityName,String cityId,Callback callback);
    interface Callback{
        void loadDatasSuccess(ResponseSection responseSection);
        void loadDatasFailed(Exception e);
    }
}
