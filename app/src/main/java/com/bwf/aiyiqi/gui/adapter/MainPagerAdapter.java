package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseMainPager;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseAotuPagerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public class MainPagerAdapter extends MyBaseAotuPagerAdapter<ResponseMainPager.DataBean> {
    public MainPagerAdapter(Context context,List<View> views) {
        super(context,views);
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=views.get(position%datas.size());
        // TODO: 2016/11/24 view设置监听
        Log.d("MainPagerAdapter", datas.get(position % datas.size()).getImagesrc2());
        SimpleDraweeView drawee = (SimpleDraweeView) view.findViewById(R.id.main_autopager_simpleDraweeView);
        drawee.setImageURI(datas.get(position%datas.size()).getImagesrc2());
        container.addView(view);
        return view;
    }
}
