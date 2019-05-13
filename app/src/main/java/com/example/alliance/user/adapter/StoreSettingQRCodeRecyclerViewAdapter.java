package com.example.alliance.user.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.alliance.R;

import java.util.List;

public class StoreSettingQRCodeRecyclerViewAdapter extends RecyclerView.Adapter implements View.OnClickListener{


    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<String> list;

    public StoreSettingQRCodeRecyclerViewAdapter(Context mContext,List<String> list) {
        super();
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.list = list;
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tableName;
        private Button mBtnDownload;
        private Button mBtnDelete;

        public ViewHolder(Context mContext, View itemView){
            super(itemView);
            tableName = itemView.findViewById(R.id.table_name);
            mBtnDownload = itemView.findViewById(R.id.btn_download);
            mBtnDelete = itemView.findViewById(R.id.btn_delete);
        }

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(mContext,mLayoutInflater.inflate(R.layout.user_store_setting_qr_code_item_layout,null));
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            ViewHolder vh = (ViewHolder)viewHolder;
            vh.tableName.setText(list.get(i));
            vh.mBtnDelete.setOnClickListener(this);
            vh.mBtnDelete.setTag(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_download:
                break;
            case R.id.btn_delete:
                list.remove((int)v.getTag());
                notifyItemRemoved((int)v.getTag());
                notifyItemChanged((int)v.getTag());
                break;

        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


}
