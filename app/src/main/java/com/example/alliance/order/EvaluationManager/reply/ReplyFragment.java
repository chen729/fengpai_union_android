package com.example.alliance.order.EvaluationManager.reply;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.alliance.R;
import com.example.alliance.base.BaseFragment;
import com.example.alliance.order.EvaluationManager.reply.adapter.ReplyRecyclerViewAdapter;

public class ReplyFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private ReplyRecyclerViewAdapter adapter;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.evaluation_manager_reply_layout,null);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        setRecyclerView();
    }

    public void setRecyclerView(){
        adapter = new ReplyRecyclerViewAdapter(mContext);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,1));
        mRecyclerView.setAdapter(adapter);
    }
}
