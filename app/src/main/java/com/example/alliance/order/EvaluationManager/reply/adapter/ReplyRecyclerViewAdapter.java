package com.example.alliance.order.EvaluationManager.reply.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.alliance.R;

public class ReplyRecyclerViewAdapter extends RecyclerView.Adapter {



    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public ReplyRecyclerViewAdapter(Context mContext) {
        super();
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView orderNumber;
        private TextView evaluator;
        private TextView phone;
        private TextView time;
        private TextView type;
        private Switch show_hide;

        public ViewHolder(Context mContext,View itemView){
            super(itemView);

            orderNumber = itemView.findViewById(R.id.order_number);
            evaluator = itemView.findViewById(R.id.evaluator);
            phone = itemView.findViewById(R.id.phone);
            time = itemView.findViewById(R.id.time);
            type = itemView.findViewById(R.id.type);
            show_hide = itemView.findViewById(R.id.show_hide);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new ViewHolder(mContext,mLayoutInflater.inflate(R.layout.evaluation_manager_reply_item_layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder vh = (ViewHolder)viewHolder;
        if (i == 0){
            vh.evaluator.setText("半个宅男");
            vh.type.setBackgroundResource(R.color.oneStar);

        }
        else if (i == 1){
            vh.evaluator.setText("小白的程序员");
            vh.type.setText("三颗星");
            vh.type.setBackgroundResource(R.color.threeStar);
        }
        vh.show_hide.setChecked(true);
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
