package com.example.alliance.order.OrderManager.reimburse.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alliance.R;

public class RequestRecyclerViewAdapter extends RecyclerView.Adapter implements View.OnClickListener{

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public RequestRecyclerViewAdapter(Context mContext) {
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
        private Button mBtnReimburse;

        public ViewHolder(Context mContext,View itemView){
            super(itemView);

            orderNumber = itemView.findViewById(R.id.order_number);
            realPay = itemView.findViewById(R.id.real_pay);
            phone = itemView.findViewById(R.id.phone);
            time = itemView.findViewById(R.id.time);
            type = itemView.findViewById(R.id.type);
            deliveryPrice = itemView.findViewById(R.id.delivery_price);
            mBtnReimburse = itemView.findViewById(R.id.reimburse);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new ViewHolder(mContext,mLayoutInflater.inflate(R.layout.order_manager_reimburse_request_item_layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder vh = (ViewHolder)viewHolder;
        vh.mBtnReimburse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reimburse:
                Toast.makeText(mContext,"退款",Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
