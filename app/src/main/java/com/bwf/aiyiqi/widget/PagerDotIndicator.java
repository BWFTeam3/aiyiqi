package com.bwf.aiyiqi.widget;


import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bwf.aiyiqi.R;

/**
 * Created by Administrator on 2016/10/20.
 */

public class PagerDotIndicator {
    private LayoutInflater inflater;
    private ViewPager viewPager;
    private LinearLayout indicatorContainer;
    private int normalDotRes;
    private int selectedDotRes;

    public PagerDotIndicator(Context context, final LinearLayout indicatorContainer, ViewPager viewPager) {
        this.inflater = LayoutInflater.from(context);
        this.viewPager = viewPager;
        this.indicatorContainer = indicatorContainer;
        this.normalDotRes = R.mipmap.home_page_controls_nor;
        this.selectedDotRes = R.mipmap.home_page_controls_hl;
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                for (int i = 0; i < indicatorContainer.getChildCount(); i++) {
                    ImageView imageView = (ImageView) indicatorContainer.getChildAt(i).findViewById(R.id.imageView_indicator_dot);
                    if (position % indicatorContainer.getChildCount() == i) {
                        imageView.setImageResource(selectedDotRes);
                    } else {
                        imageView.setImageResource(normalDotRes);
                    }
                }
            }
        });
    }

    public void setDotRes(int normalDotRes, int selectedDotRes) {
        this.normalDotRes = normalDotRes;
        this.selectedDotRes = selectedDotRes;
    }

    public void setDotNums(int size) {
        indicatorContainer.removeAllViews();
        for (int i = 0; i < size; i++) {
            View view = inflater.inflate(R.layout.subview_indicator_dots, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView_indicator_dot);
            if (i == 0) {
                imageView.setImageResource(selectedDotRes);
            } else {
                imageView.setImageResource(normalDotRes);
            }
            indicatorContainer.addView(view);
        }

    }
}
