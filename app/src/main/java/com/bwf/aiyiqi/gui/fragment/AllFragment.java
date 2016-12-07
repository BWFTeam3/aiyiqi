package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.TabBatchingData;
import com.bwf.aiyiqi.gui.adapter.order_AllAdapter;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/2.
 */
public class AllFragment extends BaseFragment {
    order_AllAdapter order_allAdapter;
    List<TabBatchingData.DataBean> data1;
    List<String> Image;
    List<String> Text;
    List<String> discount_info;
    RecyclerView recycle2;

    public AllFragment(List<TabBatchingData.DataBean> data1) {
        this.data1 = data1;
        Image = new ArrayList<>();
        Text = new ArrayList<>();
        discount_info = new ArrayList<>();
    }

    @Override
    protected int getViewResId() {
        return R.layout.allfragment;
    }

    @Override
    protected void initViews() {
        recycle2 = (RecyclerView) getView().findViewById(R.id.recycle2);
        Image = getImage();
        Text = getText();
        Log.d("AllFragment", "Text:" + Text);
        discount_info = getDiscount_info();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recycle2.setLayoutManager(gridLayoutManager);
        order_allAdapter = new order_AllAdapter(getActivity(), Image, Text, discount_info);
        recycle2.setAdapter(order_allAdapter);
    }

    private List<String> getText() {
        for (int i = 0; i < data1.size(); i++) {
            for (int j = 0; j < data1.get(i).getData1().size(); j++) {
                if (data1.get(i).getData1().get(j) != null) {
                    Text.add(data1.get(i).getData1().get(j).getBusiness_name());
                } else {
                    Text.add("0");
                }
            }
        }
        return Text;
    }

    private List<String> getImage() {
        for (int i = 0; i < data1.size(); i++) {
            for (int j = 0; j < data1.get(i).getData1().size(); j++) {
                Image.add(data1.get(i).getData1().get(j).getLogo());
            }
        }
        return Image;
    }

    private List<String> getDiscount_info() {
        for (int i = 0; i < data1.size(); i++) {
            for (int j = 0; j < data1.get(i).getData1().size(); j++) {
                discount_info.add(data1.get(i).getData1().get(j).getDiscount_info());
            }
        }
        return discount_info;
    }


    @Override
    protected void initDatas() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
