package com.bwf.aiyiqi.gui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.cjj.MaterialRefreshLayout;

/**
 * Created by Administrator on 2016/11/7.
 */

public class CustomMaterialRefreshLayout extends MaterialRefreshLayout {
    private boolean canPull = true;
    public CustomMaterialRefreshLayout(Context context) {
        super(context);
    }

    public CustomMaterialRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomMaterialRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(!canPull)
            return false;
        return super.onInterceptTouchEvent(ev);
    }
    public void setCanPull(boolean canPull){
        this.canPull = canPull;
    }
}
