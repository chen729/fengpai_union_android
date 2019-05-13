package com.example.alliance.order.EvaluationManager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.alliance.R;
import com.example.alliance.base.BaseFragment;
import com.example.alliance.order.EvaluationManager.adapter.EvaluationManagerViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/*
    评价管理Fragment
    包含两个Fragment，未回复Fragment，已回复Fragment

 */
public class EvaluationManagerFragment extends BaseFragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private EvaluationManagerViewPagerAdapter adapter;
    private FragmentManager fragmentManager;

    private List<String> tab = new ArrayList<>();

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.evaluation_manager_layout,null);
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
        tab.add("未回复");
        tab.add("已回复");
        adapter = new EvaluationManagerViewPagerAdapter(fragmentManager,tab);
        mViewPager.setCurrentItem(0);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(adapter);
    }
}
