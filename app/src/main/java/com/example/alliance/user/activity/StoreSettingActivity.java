package com.example.alliance.user.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.alliance.R;
import com.example.alliance.user.adapter.StoreSettingViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/*

    店铺设置Activity
 */

public class StoreSettingActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout mTabLayout;
    private ViewPager mViewpager;
    private ImageView mBtnBack;
    private StoreSettingViewPagerAdapter adapter;
    private FragmentManager fragmentManager;

    private List<String> list = new ArrayList<>();
    private String[] typeName = new String[]{
            "二维码",
            "自动开关",
            "推送设置",
            "打印机",
            "Wi-Fi"


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_store_setting);
        fragmentManager = getSupportFragmentManager();
        initView();
        initData();
    }

    public void initView() {
        mBtnBack = findViewById(R.id.back);
        mBtnBack.setOnClickListener(this);
        setViewpager();
        setTabLayout();
    }

    public void initData(){
        setTypeName();
        adapter = new StoreSettingViewPagerAdapter(fragmentManager,list);
        mViewpager.setAdapter(adapter);
    }

    public void setViewpager(){
        mViewpager = findViewById(R.id.view_pager);
        mViewpager.setCurrentItem(0);
    }

    public void setTabLayout(){
        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewpager);

    }

    public void setTypeName(){
        for (int i = 0;i < typeName.length;i++){
            list.add(typeName[i]);
        }
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
