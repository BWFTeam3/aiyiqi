package com.bwf.aiyiqi.gui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

import com.bwf.aiyiqi.R;

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

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        View localView1 = getChildAt(0);
        int column = getWidth()/localView1.getWidth();
        int childCount = getChildCount();
        Paint localPaint;
        localPaint = new Paint();
        localPaint.setStyle(Paint.Style.STROKE);
        localPaint.setColor(getContext().getResources().getColor(R.color.colorWhite));
        for (int i = 0;i < childCount; i++){
            View cellView = getChildAt(i);
            if ((i+1)%column == 0){
                if (i != childCount-1){
                    canvas.drawLine(cellView.getLeft(),cellView.getBottom(),cellView.getRight(),
                            cellView.getBottom(),localPaint);
                }
            }else if ((i+1)>(childCount-(childCount%column))){
                canvas.drawLine(cellView.getRight(),cellView.getTop(),cellView.getRight(),
                        cellView.getBottom(),localPaint);
            }else {
                canvas.drawLine(cellView.getRight(),cellView.getTop(),cellView.getRight(),
                        cellView.getBottom(),localPaint);
                if (i != childCount-2 && i!= childCount-3){
                    canvas.drawLine(getLeft(),cellView.getBottom(),cellView.getRight(),
                            cellView.getBottom(),localPaint);
                }
            }
        }
        if (childCount % column != 0){
            for (int j = 0;j < (column-childCount%column);j++){
                View lastView = getChildAt(childCount-1);
                canvas.drawLine(lastView.getRight(),lastView.getWidth()*j,lastView.getTop(),
                        lastView.getBottom(),localPaint);
            }
        }
    }
}
