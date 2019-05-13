package com.example.alliance.order.OrderManager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.alliance.R;
import com.example.alliance.order.OrderManager.adapter.OrderManagerViewPagerAdapter;
import com.example.alliance.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderManagerFragment extends BaseFragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private OrderManagerViewPagerAdapter adapter;
    private FragmentManager fragmentManager;

    private List<String> tab = new ArrayList<>();
    private String[] tabName = new String[]{
            "全部",
            "完成",
            "未完成",
            "退款",
            "外卖"
    };



    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.order_manager_layout,null);
        fragmentManager = getChildFragmentManager();
        mViewPager = view.findViewById(R.id.view_pager);
        mTabLayout = view.findViewById(R.id.tab_layout);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        setViewPager();
    }

    public void setViewPager(){
        for (int i = 0;i < tabName.length;i++){
            tab.add(tabName[i]);
        }

        adapter = new OrderManagerViewPagerAdapter(fragmentManager,tab);
        mViewPager.setCurrentItem(0);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(adapter);
    }


}
