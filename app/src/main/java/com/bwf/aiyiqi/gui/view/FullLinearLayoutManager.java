package com.bwf.aiyiqi.gui.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by Administrator on 2016/12/2.
 */

public class FullLinearLayoutManager extends LinearLayoutManager {
    public FullLinearLayoutManager(Context context) {
        super(context);
    }

    public FullLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override
    public boolean canScrollVertically() {
        return false;
    }
}
