package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseSection;

/**
 * Created by Administrator on 2016/12/5.
 */

public interface SectionView {
    void loadDatasSuccess(ResponseSection responseSection);
    void loadDatasFailed(Exception e);
}
