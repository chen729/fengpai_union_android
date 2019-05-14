package com.example.alliance.user.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.alliance.R;
import com.example.alliance.base.ItemDecoration;
import com.example.alliance.user.adapter.UserInformationRecyclerViewAdapter;
import com.example.alliance.user.base.UserInformation;

import java.util.ArrayList;
import java.util.List;

/*
 * 个人信息界面包括头像，姓名
 * 员工角色 充值密码
 */
public class UserInformationActivity extends AppCompatActivity implements View.OnClickListener{


    private static final String TAG = UserInformationActivity.class.getCanonicalName();

    private ImageView mBtnBack;

    private RecyclerView mRecyclerView;
    private UserInformationRecyclerViewAdapter adapter;
    private UserInformation user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_information_layout);
        initView();
        initData();
    }

    public void initView(){
        mBtnBack = findViewById(R.id.back);
        mBtnBack.setOnClickListener(this);
        setRecyclerView();

    }

    public void initData(){
        setUserInformation();
        adapter = new UserInformationRecyclerViewAdapter(UserInformationActivity.this,user);
        adapter.setOnItemClick(new UserInformationRecyclerViewAdapter.OnItemClick() {
            @Override
            public void onItemClick(View view, int position) {
                if (position == 1){
                    startActivity(new Intent(UserInformationActivity.this, UserNameActivity.class));
                }
                else if (position == 4){
                    startActivity(new Intent(UserInformationActivity.this, ResetPasswordActivity.class));
                }
            }
        });
        mRecyclerView.setAdapter(adapter);


    }

    public void setRecyclerView(){
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,1));

    }

    public void setUserInformation() {

            user = new UserInformation(R.mipmap.avatar, "迪迪丶Sir", "18718816325", "设计师");

    }

    public void onRestart(){
        super.onRestart();
        SharedPreferences pre = getSharedPreferences("user_info",MODE_PRIVATE);

        user = new UserInformation(R.mipmap.avatar, pre.getString("userName",""), "18718816325", "设计师");
        adapter = new UserInformationRecyclerViewAdapter(UserInformationActivity.this,user);
        adapter.setOnItemClick(new UserInformationRecyclerViewAdapter.OnItemClick() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("MyApp","你点击了谁："+position);
                if (position == 1){
                    startActivity(new Intent(UserInformationActivity.this, UserNameActivity.class));
                }
                else if (position == 4){
                    startActivity(new Intent(UserInformationActivity.this, ResetPasswordActivity.class));
                }
            }
        });

        mRecyclerView.setAdapter(adapter);
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
