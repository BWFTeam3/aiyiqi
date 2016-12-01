package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseRecycleAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/1.
 */

public class HeaderAdapter extends MyBaseRecycleAdapter {
    public static final int HEADER = 0;
    public static final int FOOTER = 2;
    public static final int CONTENT = 1;
    public HeaderAdapter(Context context) {
        super(context);
    }
    @Override
    // TODO: 2016/12/1 抽到父类
    public int getItemViewType(int position) {
        if (position < getHeaderCount()) return HEADER;
        if (position >= getItemCount() - getFooterCount()) return FOOTER;
        else return CONTENT;
    }

    @Override
    public int getItemCount() {
        return list.size()/2;
    }

    @Override
    public String getItem(int position) {
        return list.get((position)*2+1);
        // TODO: 2016/12/1 到时候不用加1
    }

    @Override
    protected int getFooterCount() {
        return 0;
    }

    @Override
    protected int getHeaderCount() {
        return 1;
    }

    private List<String> list=new ArrayList<>();

    public void setHeaderDatas(List<String> list) {
        this.list.add("key");
        this.list.add("全部");
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fitment_header_iem, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemHolder itemHolder = (ItemHolder) holder;
        switch (getItemViewType(position)) {
            case HEADER:
                itemHolder.fitmentHeaderItem.setBackgroundColor(Color.red(R.color.main_switch_green));
                break;
            case CONTENT:
                itemHolder.fitmentHeaderItem.setText(getItem(position) );
                break;

            case FOOTER:

                break;
        }

    }

    class ItemHolder extends BaseHolder {
        @BindView(R.id.fitment_header_item)
        TextView fitmentHeaderItem;
        ItemHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setTag(MainRecycleAdapter.HEADER);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itenListener!=null){
                        int clickPosition= getAdapterPosition();
                        itenListener.onItemClick(v,clickPosition,getItem(clickPosition));
                    }
                }
            });
        }
    }
}

