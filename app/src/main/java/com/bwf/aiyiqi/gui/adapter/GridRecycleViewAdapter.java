package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.TabBatchingData;
import com.bwf.aiyiqi.gui.activity.Orderselfr_inner;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2016/11/25.
 */

public class GridRecycleViewAdapter extends RecyclerView.Adapter {
    LayoutInflater inflater;
    Context context;
    List<TabBatchingData.DataBean.DataBean1> dataBean1s;

    public GridRecycleViewAdapter(Context context, List<TabBatchingData.DataBean.DataBean1> dataBean1s) {
        this.context = context;
        this.dataBean1s = dataBean1s;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.grid_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        MyViewHolder myViewHolder = null;
        if (myViewHolder == null) {
            myViewHolder = (MyViewHolder) holder;
        }
        myViewHolder.simplee.setImageURI(dataBean1s.get(position).getLogo());
        myViewHolder.te.setText(dataBean1s.get(position).getBusiness_name());
        myViewHolder.Lin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Orderselfr_inner.class);
                intent.putExtra("Image",dataBean1s.get(position).getLogo());
                intent.putExtra("Text",dataBean1s.get(position).getBusiness_name());
                intent.putExtra("discount_info",dataBean1s.get(position).getDiscount_info());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBean1s.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simplee)
        SimpleDraweeView simplee;
        @BindView(R.id.te)
        TextView te;
        @BindView(R.id.Lin1)
        RelativeLayout Lin1;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}