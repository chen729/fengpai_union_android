package com.example.alliance.order.EvaluationManager.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.alliance.order.EvaluationManager.reply.ReplyFragment;
import com.example.alliance.order.EvaluationManager.unanswered.UnansweredFragment;

import java.util.List;

public class EvaluationManagerViewPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGER_COUNT = 2;

    private List<String> tab;

    private UnansweredFragment unansweredFragment;
    private ReplyFragment replyFragment;



    public EvaluationManagerViewPagerAdapter(FragmentManager fm, List<String> tab) {
        super(fm);
        this.tab = tab;
        unansweredFragment = new UnansweredFragment();
        replyFragment = new ReplyFragment();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fm = null;
        switch (position){
            case 0:
                fm = unansweredFragment;
                break;
            case 1:
                fm = replyFragment;
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
