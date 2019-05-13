package com.example.alliance.order.OrderManager.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.alliance.order.OrderManager.all.AllFragment;
import com.example.alliance.order.OrderManager.complete.CompleteFragment;
import com.example.alliance.order.OrderManager.reimburse.ReimburseFragment;
import com.example.alliance.order.OrderManager.takeAway.TakeawayFragment;
import com.example.alliance.order.OrderManager.unfinished.UnfinishedFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderManagerViewPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGER_COUNT = 5;

    private List<String> tab;

    private AllFragment allFragment;
    private CompleteFragment completeFragment;
    private UnfinishedFragment unfinishedFragment;
    private ReimburseFragment reimburseFragment;
    private TakeawayFragment takeawayFragment;


    public OrderManagerViewPagerAdapter(FragmentManager fm,List<String> tab) {
        super(fm);
        this.tab = tab;
        allFragment = new AllFragment();
        completeFragment = new CompleteFragment();
        unfinishedFragment = new UnfinishedFragment();
        reimburseFragment = new ReimburseFragment();
        takeawayFragment = new TakeawayFragment();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fm = null;
        switch (position){
            case 0:
                fm = allFragment;
                break;
            case 1:
                fm = completeFragment;
                break;
            case 2:
                fm = unfinishedFragment;
                break;
            case 3:
                fm = reimburseFragment;
                break;
            case 4:
                fm = takeawayFragment;
                break;
        }
        return fm;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    public CharSequence getPageTitle(int position){
        return tab.get(position);
    }

}
