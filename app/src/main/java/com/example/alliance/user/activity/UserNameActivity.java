package com.example.alliance.user.activity;


import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.alliance.R;

/*
    个人中心
    用户名Activity

 */



public class UserNameActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = UserNameActivity.class.getCanonicalName();

    private ImageView mBtnBack;
    private EditText editName;
    private Button mBtnSave;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_name_layout);
        initView();
        initData();
    }

    public void initView(){
        mBtnBack = findViewById(R.id.back);
        editName = findViewById(R.id.edit_name);
        mBtnSave = findViewById(R.id.btn_save);
        setOnclick();

    }

    public void initData(){

    }

    public void setOnclick(){
        mBtnBack.setOnClickListener(this);
        mBtnSave.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_save:
                name = editName.getText().toString();
                SharedPreferences.Editor editor = getSharedPreferences("user_info",MODE_PRIVATE).edit();
                editor.putString("userName",name);
                editor.apply();
                finish();
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
