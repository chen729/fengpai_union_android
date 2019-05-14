package com.example.alliance.order.OrderManager.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alliance.R;
import com.example.alliance.order.OrderManager.adapter.OrderDetailsRecyclerViewAdapter;

/**
 * 订单详情界面
 */
public class OrderDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mBtnBack;

    private TextView orderNumber;
    private TextView deliveryStatus;
    private TextView estimatedTime;
    private TextView deliveryStaff;
    private TextView deliveryPrice;
    private TextView phoneCall;
    private TextView type;
    private TextView orderStatus;
    private TextView time;

    private Button mBtnSelectDelivery;
    private Button mBtnReimburse;
    private Button mBtnComplete;

    private RecyclerView mRecyclerView;
    private OrderDetailsRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_details_layout);
        initView();
        initData();
    }

    public void initView(){

        mBtnBack = findViewById(R.id.back);

        orderNumber = findViewById(R.id.order_number);
        deliveryStatus = findViewById(R.id.delivery_status);
        estimatedTime = findViewById(R.id.estimated_time);
        deliveryStaff = findViewById(R.id.delivery_staff);
        deliveryPrice = findViewById(R.id.delivery_price);
        phoneCall = findViewById(R.id.phone_call);
        type = findViewById(R.id.type);
        orderStatus = findViewById(R.id.order_status);
        time = findViewById(R.id.time);

        mBtnSelectDelivery = findViewById(R.id.select_delivery);
        mBtnReimburse = findViewById(R.id.reimburse);
        mBtnComplete = findViewById(R.id.complete);


        setOnClick();
        setRecyclerView();
    }

    public void setOnClick(){

        mBtnBack.setOnClickListener(this);
        phoneCall.setOnClickListener(this);
        mBtnSelectDelivery.setOnClickListener(this);
        mBtnReimburse.setOnClickListener(this);
        mBtnComplete.setOnClickListener(this);

    }

    public void initData(){
        adapter = new OrderDetailsRecyclerViewAdapter(this);
        mRecyclerView.setAdapter(adapter);
    }

    public void setRecyclerView(){
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.phone_call:           ////拨打电话
                String  number = "123456789101";
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+number));
                startActivity(intent);
                break;
            case R.id.select_delivery:
                Toast.makeText(OrderDetailsActivity.this,"选择配送",Toast.LENGTH_LONG).show();
                break;
            case R.id.reimburse:
                Toast.makeText(OrderDetailsActivity.this,"退款",Toast.LENGTH_LONG).show();
                break;
            case R.id.complete:
                Toast.makeText(OrderDetailsActivity.this,"确定完成",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
