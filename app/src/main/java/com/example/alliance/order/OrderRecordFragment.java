package com.example.alliance.order;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.alliance.R;
import com.example.alliance.base.BaseFragment;
import com.example.alliance.order.EvaluationManager.EvaluationManagerFragment;
import com.example.alliance.order.OrderManager.OrderManagerFragment;

/*
    订单记录的Fragment
    包括两个fragment，订单管理、评价管理
 */

public class OrderRecordFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener{

    //radioGroup控制两个fragment
    private RadioGroup radioGroup;

    private RadioButton mBtnOrderManager;

    //订单管理Fragment
    private OrderManagerFragment orderManagerFragment;
    //评价管理Fragment
    private EvaluationManagerFragment evaluationManagerFragment;
    private FragmentManager fragmentManager;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.order_record_layout,null);

        fragmentManager = getActivity().getSupportFragmentManager();

        radioGroup = view.findViewById(R.id.radio_group);

        mBtnOrderManager = view.findViewById(R.id.order_manager);

        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        radioGroup.setOnCheckedChangeListener(this);
        mBtnOrderManager.setChecked(true);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (checkedId){
            case R.id.order_manager:
                if (orderManagerFragment == null){
                    orderManagerFragment = new OrderManagerFragment();
                    transaction.add(R.id.b,orderManagerFragment);
                }
                else {
                    transaction.show(orderManagerFragment);
                }
                break;
            case R.id.evaluation_manager:
                if (evaluationManagerFragment == null){
                    evaluationManagerFragment = new EvaluationManagerFragment();
                    transaction.add(R.id.b,evaluationManagerFragment);
                }
                else{
                    transaction.show(evaluationManagerFragment);
                }
        }
        transaction.commit();

    }

    public void hideFragment(FragmentTransaction transaction){
        if (orderManagerFragment != null){
            transaction.hide(orderManagerFragment);
        }
        if (evaluationManagerFragment != null){
            transaction.hide(evaluationManagerFragment);
        }
    }
}































