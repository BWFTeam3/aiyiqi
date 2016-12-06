package com.bwf.aiyiqi.mvp.modle;

import com.bwf.aiyiqi.entity.ResponseNewest;

/**
 * Created by Administrator on 2016/12/4.
 */

public interface NewestModel {
    void loadDatas(String cityName, int page, int pageSize, Callback callback);

    interface Callback {
        void loadDatasSuccess(ResponseNewest responseNewest);

        void loadDatasFailed(Exception e);
    }
}
