package com.example.alliance.user.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alliance.R;

public class MessageRecordRecyclerViewAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MessageRecordRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(Context mContext, View itemView){
            super(itemView);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(mContext,mLayoutInflater.inflate(R.layout.user_message_record_item_layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
