package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseBuilding;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseBuildingAdapter;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBuildingViewHolder;

/**
 * Created by 11645 on 2016/12/4.
 */

public class BuildingAdapter extends MyBaseBuildingAdapter<ResponseBuilding.DataBean.ChildrenBean> {
    public BuildingAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void setViewContent(MyBuildingViewHolder holder, ResponseBuilding.DataBean.ChildrenBean childrenBean) {
        holder.setTextView(R.id.item_textview,childrenBean.getTitle());
    }
}
