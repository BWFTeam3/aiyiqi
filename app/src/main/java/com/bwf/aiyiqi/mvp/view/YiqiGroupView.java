package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseYiqiGroup;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface YiqiGroupView {
    void loadSuccess(ResponseYiqiGroup responseYiqiGroup);
    void loadFailed(Exception e);
    void noMoreData();
}
