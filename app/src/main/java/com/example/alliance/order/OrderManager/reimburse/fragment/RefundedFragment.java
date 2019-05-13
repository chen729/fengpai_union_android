package com.example.alliance.order.OrderManager.reimburse.fragment;

import android.view.View;

import com.example.alliance.R;
import com.example.alliance.base.BaseFragment;

public class RefundedFragment extends BaseFragment {
    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.order_manager_reimburse_refunded_layout,null);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
    }
}
