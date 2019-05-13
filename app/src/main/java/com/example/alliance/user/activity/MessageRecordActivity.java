package com.example.alliance.user.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.alliance.R;
import com.example.alliance.user.adapter.MessageRecordRecyclerViewAdapter;
/*
    信息记录Activity

 */
public class MessageRecordActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView mBtnBack;
    private RecyclerView mRecyclerView;
    private MessageRecordRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_message_record);
        initView();
        initData();
    }

    public void initView(){
        mBtnBack = findViewById(R.id.back);
        setRecyclerView();
        setOnclick();
    }

    public void setOnclick() {
        mBtnBack.setOnClickListener(this);
    }

    public void initData(){
        adapter = new MessageRecordRecyclerViewAdapter(this);
        mRecyclerView.setAdapter(adapter);
    }

    public void setRecyclerView(){
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
}
