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
import com.bwf.aiyiqi.gui.activity.Orderselfr_inner;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/2.
 */

public class order_AllAdapter extends RecyclerView.Adapter {
    LayoutInflater layoutInflater;
    List<String> Image;
    List<String> Text;
    List<String> discount_info;
    Context context;

    public order_AllAdapter(Context context, List<String> Image, List<String> Text,List<String> discount_info) {
        layoutInflater = LayoutInflater.from(context);
        this.Image = Image;
        this.Text = Text;
        this.discount_info = discount_info;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.grid_view, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            viewHolder = (ViewHolder) holder;
        }
        viewHolder.simplee.setImageURI(Image.get(position));
        viewHolder.te.setText(Text.get(position));
        viewHolder.Lin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Orderselfr_inner.class);
                intent.putExtra("Image",Image.get(position));
                intent.putExtra("Text",Text.get(position));
                intent.putExtra("discount_info",discount_info.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Image.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simplee)
        SimpleDraweeView simplee;
        @BindView(R.id.te)
        TextView te;
        @BindView(R.id.Lin1)
        RelativeLayout Lin1;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
