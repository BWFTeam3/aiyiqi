package com.bwf.aiyiqi.mvp.modle;

import com.bwf.aiyiqi.entity.ResponseElite;

/**
 * Created by Administrator on 2016/12/4.
 */

public interface EliteModel {
    void loadDatas(int page, int pageSize, Callback callback);

    interface Callback {
        void loadDatasSuccess(ResponseElite responseElite);

        void loadDatasFailed(Exception e);
    }
}
