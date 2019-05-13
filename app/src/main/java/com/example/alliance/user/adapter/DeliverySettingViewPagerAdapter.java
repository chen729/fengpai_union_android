package com.example.alliance.user.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.alliance.user.fragment.DeliveryRecordFragment;
import com.example.alliance.user.fragment.DeliverySettingFragment;

import java.util.List;

public class DeliverySettingViewPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGER_COUNT = 2;

    private List<String> tab;
    private DeliverySettingFragment deliverySettingFragment;
    private DeliveryRecordFragment deliveryRecordFragment;



    public DeliverySettingViewPagerAdapter(FragmentManager fm, List<String> tab) {
        super(fm);
        this.tab = tab;
        deliverySettingFragment = new DeliverySettingFragment();
        deliveryRecordFragment = new DeliveryRecordFragment();

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fm = null;
        switch (position){
            case 0:
                fm = deliverySettingFragment;
                break;
            case 1:
                fm = deliveryRecordFragment;
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
