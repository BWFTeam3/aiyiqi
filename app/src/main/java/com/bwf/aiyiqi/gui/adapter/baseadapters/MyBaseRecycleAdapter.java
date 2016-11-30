package com.bwf.aiyiqi.gui.adapter.baseadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.bwf.aiyiqi.gui.adapter.MainRecycleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */

public abstract class MyBaseRecycleAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<T> datas;
    private Context context;
    protected LayoutInflater inflater;

    public MyBaseRecycleAdapter(Context context) {
        this.context = context;
        datas=new ArrayList<>();
        inflater=LayoutInflater.from(context);
    }

    public void setDatas(List<T> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }
    public void addDatas(List<T> datas) {
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }
    public void clearDatas( ){
        this.datas.clear();
        notifyDataSetChanged();
    }
    protected  Context getContext(){
        return context;
    }
    @Override
    public int getItemCount() {
        return datas.size()+getHeaderCount()+getFooterCount();
    }

    protected abstract int getFooterCount();

    protected abstract int getHeaderCount();

    public T getItem(int position) {
        if (datas.size()==0){
            return null;
        }
        return datas.get(position-getHeaderCount());
    }


    protected class BaseHolder extends RecyclerView.ViewHolder {
        public BaseHolder(View view) {
            super(view);
            view.setTag(MainRecycleAdapter.CONTENT);
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
    protected class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View view) {
            super(view);
            view.setTag(MainRecycleAdapter.FOOTER);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itenListener!=null){
                        int clickPosition= getAdapterPosition();
                        itenListener.onItemClick(v,clickPosition,getItem(clickPosition-getFooterCount()));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener<T>{
        void onItemClick(View view , int pesition,T data);
    }
    private OnItemClickListener itenListener;
    public void setOnItemClickListener(OnItemClickListener itenListener){
        this.itenListener=itenListener;
    }
}
