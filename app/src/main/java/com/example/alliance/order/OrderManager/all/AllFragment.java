package com.example.alliance.order.OrderManager.all;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.alliance.R;
import com.example.alliance.order.OrderManager.all.adapter.AllRecyclerViewAdapter;
import com.example.alliance.base.BaseFragment;
/*
    全部 Fragment

 */
public class AllFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private AllRecyclerViewAdapter adapter;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.order_manager_all_layout,null);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        setRecyclerView();
    }

    public void setRecyclerView(){
        adapter = new AllRecyclerViewAdapter(mContext);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,1));
        mRecyclerView.setAdapter(adapter);
    }
}
