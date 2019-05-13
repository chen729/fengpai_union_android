package com.example.alliance.order.OrderManager.all.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alliance.R;
import com.example.alliance.order.OrderManager.activity.OrderDetailsActivity;

public class AllRecyclerViewAdapter extends RecyclerView.Adapter implements View.OnClickListener{



    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public AllRecyclerViewAdapter(Context mContext) {
        super();
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        private CardView mCardView;
        private TextView orderNumber;
        private TextView realPay;
        private TextView phone;
        private TextView time;
        private TextView type;
        private TextView deliveryPrice;
        private TextView deliveryStatus;
        private TextView requestReimburse;
        private LinearLayout deliveryPriceLinearLayout;
        private LinearLayout requestReimburseLinearLayout;


        public ViewHolder(Context mContext,View itemView){
            super(itemView);
            mCardView = itemView.findViewById(R.id.card_view);
            orderNumber = itemView.findViewById(R.id.order_number);
            realPay = itemView.findViewById(R.id.real_pay);
            phone = itemView.findViewById(R.id.phone);
            time = itemView.findViewById(R.id.time);
            type = itemView.findViewById(R.id.type);
            deliveryPrice = itemView.findViewById(R.id.delivery_price);
            deliveryStatus = itemView.findViewById(R.id.delivery_status);
            requestReimburse = itemView.findViewById(R.id.request_reimburse);
            deliveryPriceLinearLayout = itemView.findViewById(R.id.delivery_price_linearlayout);
            requestReimburseLinearLayout = itemView.findViewById(R.id.request_reimburse_linearlayout);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new ViewHolder(mContext,mLayoutInflater.inflate(R.layout.order_manager_all_item_layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder vh = (ViewHolder)viewHolder;
        vh.mCardView.setOnClickListener(this);
        if (i == 1){
            vh.deliveryStatus.setText("已完成");
            vh.deliveryStatus.setTextColor(Color.BLACK);
            vh.deliveryStatus.setBackgroundResource(R.color.finishedColor);
            vh.requestReimburse.setText("已退款");
            vh.requestReimburse.setBackgroundResource(R.color.refundedColor);
        }
        else if (i == 2){
            vh.type.setText("到店自取");
            vh.type.setBackgroundResource(R.color.takeInTheStore);
            vh.deliveryPriceLinearLayout.setVisibility(View.INVISIBLE);
            vh.requestReimburseLinearLayout.setVisibility(View.INVISIBLE);
        }
        else if(i == 3){
            vh.type.setText("到店自取");
            vh.type.setBackgroundResource(R.color.takeInTheStore);
            vh.deliveryStatus.setText("已完成");
            vh.deliveryStatus.setBackgroundResource(R.color.finishedColor);
            vh.deliveryPriceLinearLayout.setVisibility(View.INVISIBLE);
            vh.requestReimburseLinearLayout.setVisibility(View.INVISIBLE);

        }

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.card_view:
                Intent intent = new Intent(mContext, OrderDetailsActivity.class);
                mContext.startActivity(intent);
                break;
        }
    }

}