package com.bwf.aiyiqi.gui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2016/11/27.
 */

public class YiqigroupGridView extends GridView {
    private OnScrollChangedListener onScrollChangedListener;

    public YiqigroupGridView.OnScrollChangedListener getOnScrollChangedListener() {
        return onScrollChangedListener;
    }

    public void setOnScrollChangedListener(YiqigroupGridView.OnScrollChangedListener onScrollChangedListener) {
        this.onScrollChangedListener = onScrollChangedListener;
    }
    public YiqigroupGridView(Context context) {
        super(context);
    }

    public YiqigroupGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public YiqigroupGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(onScrollChangedListener != null)
            onScrollChangedListener.onScrollChanged(l,t,oldl,oldt);
    }
    public interface OnScrollChangedListener{
        void onScrollChanged(int l, int t, int oldl, int oldt);
    }
}
