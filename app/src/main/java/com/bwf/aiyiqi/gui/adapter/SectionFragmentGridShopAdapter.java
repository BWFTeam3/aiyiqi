package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseSection;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/6.
 */

public class SectionFragmentGridShopAdapter extends MyBaseAdapter<List<ResponseSection.DataBean>> {

    public SectionFragmentGridShopAdapter(Context context) {
        super(context);
    }

    @Override
    public int getCount() {
        if (datas.size() == 0)
            return 0;
        return datas.get(1).size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("aa", "position:" + position);
        ResponseSection.DataBean dataBean = datas.get(1).get(position);
        View view = inflater.inflate(R.layout.item_section_fragment_shop, parent, false);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.simpleDraweeView_shop);
        TextView textViewTitle = (TextView) view.findViewById(R.id.textView_title);
        TextView textViewNum = (TextView) view.findViewById(R.id.textView_number);
        View viewLine = view.findViewById(R.id.view_line);
        if (datas.get(1).size() % 2 == 0 && datas.get(1).size() - position <= 2) {
            viewLine.setVisibility(View.GONE);
        } else if (datas.get(1).size() % 2 == 1 & datas.get(1).size() - position == 1) {
            viewLine.setVisibility(View.GONE);
        }
        simpleDraweeView.setImageURI(dataBean.getIcon());
        textViewTitle.setText(dataBean.getTitle());
        textViewNum.setText("总贴：" + dataBean.getThreadsnum());
        return view;
    }
}
