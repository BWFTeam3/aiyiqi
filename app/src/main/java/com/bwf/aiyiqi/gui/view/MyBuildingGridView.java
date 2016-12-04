package com.bwf.aiyiqi.gui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by 11645 on 2016/12/4.
 */

public class MyBuildingGridView extends GridView {
    public MyBuildingGridView(Context context) {
        super(context);
    }

    public MyBuildingGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyBuildingGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 3,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
