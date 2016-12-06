package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseElite;

/**
 * Created by Administrator on 2016/12/4.
 */

public interface EliteView {
    void loadSuccess(ResponseElite responseElite);
    void loadFailed(Exception e);
    void noMoreData();
}
