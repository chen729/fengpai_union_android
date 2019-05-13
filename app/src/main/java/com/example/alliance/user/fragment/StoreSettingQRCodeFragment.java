package com.example.alliance.user.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.alliance.R;
import com.example.alliance.base.BaseFragment;
import com.example.alliance.user.adapter.StoreSettingQRCodeRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class StoreSettingQRCodeFragment extends BaseFragment implements View.OnClickListener{

    private Button mBtnAddTable;
    private ImageView mBtnSearch;

    private RecyclerView mRecyclerView;
    private StoreSettingQRCodeRecyclerViewAdapter adapter;
    private List<String> list = new ArrayList<>();
    private String[] tableName = new String[]{
            "1号",
            "2号",
            "3号",
            "4号",
            "5号"
    };

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.user_store_setting_qr_code_layout,null);
        mBtnAddTable = view.findViewById(R.id.add_table_number);
        mBtnSearch = view.findViewById(R.id.search);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        setOnClick();
        return view;
    }


    public void setOnClick(){
        mBtnAddTable.setOnClickListener(this);
        mBtnSearch.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        super.initData();
        setTableName();
        adapter = new StoreSettingQRCodeRecyclerViewAdapter(mContext,list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,1));
        mRecyclerView.setAdapter(adapter);
    }

    public void setTableName(){
        for (int i = 0;i < tableName.length;i++){
            list.add(tableName[i]);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.add_table_number:
                Toast.makeText(mContext,"添加桌号",Toast.LENGTH_LONG).show();
                break;
            case R.id.search:
                Toast.makeText(mContext,"搜索",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
