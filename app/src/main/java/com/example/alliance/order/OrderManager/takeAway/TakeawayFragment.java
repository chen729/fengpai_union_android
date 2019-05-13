package com.example.alliance.order.OrderManager.takeAway;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.alliance.R;
import com.example.alliance.base.BaseFragment;
import com.example.alliance.order.OrderManager.takeAway.adapter.TakeawayRecyclerViewAdapter;

/*
    外卖 Fragment

 */
public class TakeawayFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private TakeawayRecyclerViewAdapter adapter;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.order_manager_takeaway_layout,null);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        setRecyclerView();
    }

    public void setRecyclerView(){
        adapter = new TakeawayRecyclerViewAdapter(mContext);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,1));
        mRecyclerView.setAdapter(adapter);
    }
}
