package com.example.alliance.user.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.alliance.R;

/*
    个人中心
    重置密码Activity
 */

public class ResetPasswordActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView mBtnBack;
    private EditText editPassword;
    private EditText editPasswordAgain;
    private Button mBtnSave;
    private String passwordA,passwordB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_reset_password);
        initView();
        initData();
    }

    public void initView(){
        mBtnBack = findViewById(R.id.back);
        editPassword = findViewById(R.id.password);
        editPasswordAgain = findViewById(R.id.password_again);
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
            case R.id.back:
                finish();
                break;

            case R.id.btn_save:
                passwordA = editPassword.getText().toString();
                passwordB = editPasswordAgain.getText().toString();
                if (passwordA.equals(passwordB)){
                    Toast.makeText(ResetPasswordActivity.this,"重置密码成功",Toast.LENGTH_LONG).show();
                    finish();
                }
                else
                {
                    Toast.makeText(ResetPasswordActivity.this,"密码不一致",Toast.LENGTH_LONG).show();
                    editPassword.setText("");
                    editPasswordAgain.setText("");
                }

        }

    }
}
