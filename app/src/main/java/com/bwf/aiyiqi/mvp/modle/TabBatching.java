package com.bwf.aiyiqi.mvp.modle;


import com.bwf.aiyiqi.entity.TabBatchingData;

/**
 * Created by Administrator on 2016/11/24.
 */

public interface TabBatching {
    public void LoadTabBatching(TabBatchingLoadingCallBack callBack);
    interface TabBatchingLoadingCallBack{
        void LoadSuccess(TabBatchingData responce);
        void LoadFaild();
    }
}
