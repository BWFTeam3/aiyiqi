package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseNewest;

/**
 * Created by Administrator on 2016/12/5.
 */

public interface NewestView {
    void loadDatasSuccess(ResponseNewest responseNewest);
    void loadDatasFailed(Exception e);
    void noMoreData();
}
