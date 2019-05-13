package com.example.alliance.order.OrderManager.reimburse;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.alliance.R;
import com.example.alliance.base.BaseFragment;
import com.example.alliance.order.OrderManager.reimburse.fragment.RefundedFragment;
import com.example.alliance.order.OrderManager.reimburse.fragment.RequestFragment;

/*
    退款 Fragment

 */

public class ReimburseFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroup;
    private RadioButton mBtnRequest;

    private RequestFragment requestFragment;
    private RefundedFragment refundedFragment;
    private FragmentManager fragmentManager;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.order_manager_reimburse_layout,null);
        fragmentManager = getChildFragmentManager();
        radioGroup = view.findViewById(R.id.radio_group);
        mBtnRequest = view.findViewById(R.id.request);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        radioGroup.setOnCheckedChangeListener(this);
        mBtnRequest.setChecked(true);
    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch(checkedId){
            case R.id.request:
                if (requestFragment == null){
                    requestFragment = new RequestFragment();
                    transaction.add(R.id.c,requestFragment);
                }
                else{
                    transaction.show(requestFragment);
                }
                break;
            case R.id.refunded:
                if (refundedFragment == null){
                    refundedFragment = new RefundedFragment();
                    transaction.add(R.id.c,refundedFragment);
                }
                else{
                    transaction.show(refundedFragment);
                }
                break;
        }
        transaction.commit();
    }

    public void hideFragment(FragmentTransaction transaction) {
        if (requestFragment != null){
            transaction.hide(requestFragment);
        }
        if (refundedFragment != null){
            transaction.hide(refundedFragment);
        }
    }

}
