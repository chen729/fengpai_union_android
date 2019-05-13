package com.example.alliance.user.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.alliance.R;
import com.example.alliance.user.adapter.StoreInformationRecyclerViewAdapter;
import com.example.alliance.user.base.StoreInformation;

/*
    店铺信息Activity

 */

public class StoreInformationActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mBtnBack;
    private ImageView logoImage;
    private ImageView licenseImage;
    private Button mBtnUpdateLogoImage;
    private Button mBtnUpdateLicenseImage;
    private RecyclerView mRecyclerView;
    private StoreInformationRecyclerViewAdapter adapter;
    private StoreInformation storeInformation;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_store_information);
        initView();
        initData();

    }

    public void initView(){
        mBtnBack = findViewById(R.id.back);
        logoImage = findViewById(R.id.logo_image);
        licenseImage = findViewById(R.id.license_image);
        mBtnUpdateLogoImage = findViewById(R.id.btn_update_logo);
        mBtnUpdateLicenseImage = findViewById(R.id.btn_update_license);
        setRecyclerView();
        setOnclick();
    }

    public void setOnclick() {
        mBtnBack.setOnClickListener(this);
        mBtnUpdateLogoImage.setOnClickListener(this);
        mBtnUpdateLicenseImage.setOnClickListener(this);
    }

    public void initData(){
        setStoreInformation();
        adapter = new StoreInformationRecyclerViewAdapter(this,storeInformation);
        mRecyclerView.setAdapter(adapter);
    }

    public void setRecyclerView(){
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }

    public void setStoreInformation(){
        storeInformation = new StoreInformation("摩坊起司","迪迪丶Sir","18718816325","梅州市蜂派科技网络有限公司","IT");

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.btn_update_logo:
                Toast.makeText(StoreInformationActivity.this,"更换logo图片",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_update_license:
                Toast.makeText(StoreInformationActivity.this,"更换营业执照",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
