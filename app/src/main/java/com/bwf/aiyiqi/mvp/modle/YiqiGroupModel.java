package com.bwf.aiyiqi.mvp.modle;

import com.bwf.aiyiqi.entity.ResponseYiqiGroup;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface YiqiGroupModel {
    void loadDatas(String type, int pageNo, String pageSize, Callback callback);

    interface Callback {
        void loadSuccess(ResponseYiqiGroup responseYiqiGroup);

        void loadFailed(Exception e);

        void noMoreData();
    }
}
