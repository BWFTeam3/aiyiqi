package com.bwf.aiyiqi.mvp.view;

/**
 * Created by Phyj on 2016/12/3.
 */

public interface DesignView {
    void showSuccess(String response);
    void showFaild(Exception e);
    void showNextSuccess(String response);
    void showNextFaild(Exception e);
}
