package com.example.alliance.order.OrderManager.unfinished;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.alliance.R;
import com.example.alliance.base.BaseFragment;
import com.example.alliance.order.OrderManager.unfinished.adapter.UnfinishedRecyclerViewAdapter;

/*
   未完成 Fragment

 */
public class UnfinishedFragment extends BaseFragment implements View.OnClickListener{

    private Button mBtnOneKeyFinish;
    private RecyclerView mRecyclerView;
    private UnfinishedRecyclerViewAdapter adapter;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.order_manager_unfinished_layout,null);
        mBtnOneKeyFinish = view.findViewById(R.id.one_key_finish);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        mBtnOneKeyFinish.setOnClickListener(this);
        setRecyclerView();
    }

    public void setRecyclerView() {
        adapter = new UnfinishedRecyclerViewAdapter(mContext);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,1));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.one_key_finish:
                Toast.makeText(mContext,"一键完成",Toast.LENGTH_LONG).show();
                break;
        }
    }


}
