package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBasePagerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/29.
 */

public class ViewPagerPageAdapter extends MyBasePagerAdapter<String> {

    public ViewPagerPageAdapter(Context context, List<View> views) {
        super(context);
        this.views = views;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.simpleDraweeView_page);
        simpleDraweeView.setImageURI(datas.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }
}
