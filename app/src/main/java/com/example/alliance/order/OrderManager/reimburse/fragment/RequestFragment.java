package com.example.alliance.order.OrderManager.reimburse.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.alliance.R;
import com.example.alliance.base.BaseFragment;
import com.example.alliance.order.OrderManager.reimburse.adapter.RequestRecyclerViewAdapter;

public class RequestFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private RequestRecyclerViewAdapter adapter;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.order_manager_reimburse_request_layout,null);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        adapter = new RequestRecyclerViewAdapter(mContext);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,1));
        mRecyclerView.setAdapter(adapter);
    }

}
