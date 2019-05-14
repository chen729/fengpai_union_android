package com.example.alliance.user.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.alliance.R;
import com.example.alliance.user.adapter.DeliverySettingViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;


/* 配送设置Activity */
public class DeliverySettingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mBtnBack;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private DeliverySettingViewPagerAdapter adapter;
    private FragmentManager fragmentManager;
    private List<String> list = new ArrayList<>();
    private String[] typeName = new String[]{
      "配送设置",
      "配送记录"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_delivery_setting);
        fragmentManager = getSupportFragmentManager();
        initView();
        initData();

    }

    public void initView(){
        mBtnBack = findViewById(R.id.back);
        setViewPager();
        setTabLayout();
        setOnClick();

    }

    public void setOnClick(){
        mBtnBack.setOnClickListener(this);
    }

    public void initData(){
        for (int i = 0;i < typeName.length;i++){
            list.add(typeName[i]);
        }
        adapter = new DeliverySettingViewPagerAdapter(fragmentManager,list);
        mViewPager.setAdapter(adapter);
    }

    public void setViewPager(){
        mViewPager = findViewById(R.id.view_pager);
        mViewPager.setCurrentItem(0);

    }

    public void setTabLayout(){
        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
}
