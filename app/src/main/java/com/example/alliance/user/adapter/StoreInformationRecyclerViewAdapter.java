package com.example.alliance.user.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alliance.R;
import com.example.alliance.user.base.StoreInformation;



public class StoreInformationRecyclerViewAdapter extends RecyclerView.Adapter implements View.OnClickListener{



    private static final int ITEM_COUNT = 5;


    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private StoreInformation storeInformation;
    private ViewHolder vh;
    private TextView text;
    String[] attrStr = {"店铺名称","店铺联系人:","联系电话:","店铺地址:","行业:"};

    public StoreInformationRecyclerViewAdapter(Context mContext, StoreInformation storeInformation) {
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.storeInformation = storeInformation;
    }



    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView type;
        private TextView typeName;
        private ImageView mBtnRightArrow;
        private LinearLayout llItem;            ////一整行，用于点击事件

        public ViewHolder(Context mContext, View itemView){
            super(itemView);
            type = itemView.findViewById(R.id.type);
            typeName = itemView.findViewById(R.id.type_name);
            mBtnRightArrow = itemView.findViewById(R.id.btn_right_arrow);
            llItem = itemView.findViewById(R.id.llItem);        ////一整行，用于点击事件
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new ViewHolder(mContext,mLayoutInflater.inflate(R.layout.user_store_information_item_layout,null));

    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        vh = (ViewHolder)viewHolder;

        /*if (i == 0){
            text = vh.typeName;
            vh.type.setText();
            vh.typeName.setText(storeInformation.getStoreName());
            vh.mBtnRightArrow.setOnClickListener(this);
            vh.mBtnRightArrow.setTag(i);
        }

        else if (i == 1){
            vh.type.setText();
            vh.typeName.setText(storeInformation.getStoreOwner());
            vh.mBtnRightArrow.setOnClickListener(this);
            vh.mBtnRightArrow.setTag(i);
        }
        else if (i == 2){
            vh.type.setText();
            vh.typeName.setText(storeInformation.getPhone());
            vh.mBtnRightArrow.setOnClickListener(this);
            vh.mBtnRightArrow.setTag(i);

        }
        else if(i == 3){
            vh.type.setText();
            vh.typeName.setText(storeInformation.getStoreAddress());
            vh.mBtnRightArrow.setOnClickListener(this);
            vh.mBtnRightArrow.setTag(i);
        }
        else if (i == 4){
            vh.type.setText();
            vh.typeName.setText(storeInformation.getType());
            vh.mBtnRightArrow.setOnClickListener(this);
            vh.mBtnRightArrow.setTag(i);
        }*/


        /////201905131632  update by jack
        switch (i){
            case 0:
                text = vh.typeName;
                break;
        }
        if (i <= attrStr.length )
            vh.type.setText(attrStr[i]);
        vh.typeName.setText(storeInformation.getStoreName());
        vh.llItem.setOnClickListener(this);
        vh.llItem.setTag(i);

    }

    @Override
    public void onClick(View v) {
        String[] titleCount = {"请输入店铺名称","请输入店铺联系人","请输入联系电话","请输入店铺地址","请输入行业"};
        final EditText editText = new EditText(mContext);
        int index = (int)v.getTag();
        AlertDialog.Builder input = new AlertDialog.Builder(mContext);
        input.setTitle(titleCount[index]).setView(editText);
        input.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                text.setText(editText.getText().toString());
            }
        }).show();

    }



    @Override
    public int getItemCount() {
        return ITEM_COUNT;
    }


}
