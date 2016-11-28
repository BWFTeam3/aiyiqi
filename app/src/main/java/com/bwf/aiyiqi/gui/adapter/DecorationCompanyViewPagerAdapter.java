package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseFlashView;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseAotuPagerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public class DecorationCompanyViewPagerAdapter extends MyBaseAotuPagerAdapter<ResponseFlashView.DataBean> {

    public DecorationCompanyViewPagerAdapter(Context context, List<View> views) {
        super(context,views);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (views.size()==0) return null;
        // TODO: 2016/11/24 带检查
        View view = views.get(position % datas.size());
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.simpleDraweeView_view);
        simpleDraweeView.setImageURI(datas.get(position % datas.size()).getImagesrc2());
        if (container.getChildCount() == datas.size())
            container.removeView(view);
        container.addView(view);
        return view;
    }


}
