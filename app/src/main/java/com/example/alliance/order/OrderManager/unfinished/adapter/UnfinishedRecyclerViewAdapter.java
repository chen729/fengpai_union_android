package com.example.alliance.order.OrderManager.unfinished.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alliance.R;

public class UnfinishedRecyclerViewAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public UnfinishedRecyclerViewAdapter(Context mContext) {
        super();
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView orderNumber;
        private TextView realPay;
        private TextView phone;
        private TextView time;
        private TextView type;
        private TextView deliveryPrice;
        private LinearLayout deliveryPriceLinearLayout;

        public ViewHolder(Context mContext,View itemView){
            super(itemView);

            orderNumber = itemView.findViewById(R.id.order_number);
            realPay = itemView.findViewById(R.id.real_pay);
            phone = itemView.findViewById(R.id.phone);
            time = itemView.findViewById(R.id.time);
            type = itemView.findViewById(R.id.type);
            deliveryPrice = itemView.findViewById(R.id.delivery_price);
            deliveryPriceLinearLayout = itemView.findViewById(R.id.delivery_price_linearlayout);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new ViewHolder(mContext,mLayoutInflater.inflate(R.layout.order_manager_unfinished_item_layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder vh = (ViewHolder)viewHolder;
        if (i == 2){
            vh.type.setText("到店自取");
            vh.type.setBackgroundResource(R.color.takeInTheStore);
            vh.deliveryPriceLinearLayout.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
