package com.example.alliance.user.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.alliance.user.fragment.DeliveryRecordFragment;
import com.example.alliance.user.fragment.DeliverySettingFragment;
import com.example.alliance.user.fragment.StoreSettingAutoSwitchFragment;
import com.example.alliance.user.fragment.StoreSettingPrinterFragment;
import com.example.alliance.user.fragment.StoreSettingPushFragment;
import com.example.alliance.user.fragment.StoreSettingQRCodeFragment;
import com.example.alliance.user.fragment.StoreSettingWifiFragment;

import java.util.List;

public class StoreSettingViewPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGER_COUNT = 5;

    private List<String> tab;
    private StoreSettingQRCodeFragment storeSettingQRCodeFragment;
    private StoreSettingAutoSwitchFragment storeSettingAutoSwitchFragment;
    private StoreSettingPushFragment storeSettingPushFragment;
    private StoreSettingPrinterFragment printerFragment;
    private StoreSettingWifiFragment storeSettingWifiFragment;



    public StoreSettingViewPagerAdapter(FragmentManager fm, List<String> tab) {
        super(fm);
        this.tab = tab;
        this.storeSettingQRCodeFragment = new StoreSettingQRCodeFragment();
        this.storeSettingAutoSwitchFragment = new StoreSettingAutoSwitchFragment();
        this.storeSettingPushFragment = new StoreSettingPushFragment();
        this.printerFragment = new StoreSettingPrinterFragment();
        this.storeSettingWifiFragment = new StoreSettingWifiFragment();


    }

    @Override
    public Fragment getItem(int position) {
        Fragment fm = null;
        switch (position){
            case 0:
                fm = storeSettingQRCodeFragment;
                break;
            case 1:
                fm = storeSettingAutoSwitchFragment;
                break;
            case 2:
                fm = storeSettingPushFragment;
                break;
            case 3:
                fm = printerFragment;
                break;
            case 4:
                fm = storeSettingWifiFragment;
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
