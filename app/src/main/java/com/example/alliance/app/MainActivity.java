package com.example.alliance.app;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.alliance.R;
import com.example.alliance.base.BaseActivity;
import com.example.alliance.order.OrderRecordFragment;
import com.example.alliance.user.UserFragment;

/*
    主界面
    包含两个fragment，一个是订单记录，一个是个人中心
 */
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioGroup radioGroup;
    private RadioButton mBtnOrderRecord;


    private OrderRecordFragment orderRecordFragment;
    private UserFragment userFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    public void initView(){
        setFragment();
        setRadioGroup();
    }

    public void initData(){



    }

    /*
        获取fragmentManger

    */

    public void setFragment() {
        fragmentManager = getSupportFragmentManager();
    }

    public void setRadioGroup() {
        radioGroup = findViewById(R.id.radio_group);
        mBtnOrderRecord = findViewById(R.id.order_record);
        radioGroup.setOnCheckedChangeListener(this);
        mBtnOrderRecord.setChecked(true);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (checkedId){
            case R.id.order_record:
                if (orderRecordFragment == null){
                    orderRecordFragment = new OrderRecordFragment();
                    transaction.add(R.id.a,orderRecordFragment);
                }
                else{
                    transaction.show(orderRecordFragment);
                }
                break;
            case R.id.user:
                if (userFragment == null){
                    userFragment = new UserFragment();
                    transaction.add(R.id.a,userFragment);
                }
                else {
                    transaction.show(userFragment);
                }
                break;
        }
        transaction.commit();
    }

    public void hideFragment(FragmentTransaction transaction){
        if (orderRecordFragment != null){
            transaction.hide(orderRecordFragment);
        }
        if (userFragment != null){
            transaction.hide(userFragment);
        }
    }
}
