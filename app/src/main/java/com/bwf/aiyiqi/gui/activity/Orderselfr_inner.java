package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.adapter.order_inner_Adapter;
import com.facebook.drawee.view.SimpleDraweeView;


/**
 * Created by Administrator on 2016/12/5.
 */

public class Orderselfr_inner extends BaseActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    ImageView imageView;
    TextView textView;
    Button button;
    order_inner_Adapter order_inner_adapter;
    String Image;
    String Text;
    String discount_info;

    @Override
    protected int getViewResId() {
        return R.layout.order_self_inner;
    }

    @Override
    protected void initViews() {
        button = (Button) findViewById(R.id.image_inner);
        imageView = (SimpleDraweeView)findViewById(R.id.image22);
        textView = (TextView)findViewById(R.id.text3);
        tabLayout = (TabLayout) findViewById(R.id.Tab_inner);
        viewPager = (ViewPager) findViewById(R.id.ViewPager_inner);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Orderselfr_inner.this,LoginAndRegistActivity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        Image =intent.getStringExtra("Image");
        Text = intent.getStringExtra("Text");
        discount_info = intent.getStringExtra("discount_info");
        textView.setText(Text);
        imageView.setImageURI(Uri.parse(Image));

        order_inner_adapter = new order_inner_Adapter(getSupportFragmentManager(),discount_info);
        viewPager.setAdapter(order_inner_adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void initDatas() {

    }

    public void Onclick(View view){
        finish();
    }
    public void OnClick1(View view){
        Intent intent = new Intent(this,LoginAndRegistActivity.class);
        startActivity(intent);
    }
}
