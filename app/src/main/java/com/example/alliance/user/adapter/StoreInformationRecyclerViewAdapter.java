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

    public StoreInformationRecyclerViewAdapter(Context mContext, StoreInformation storeInformation) {
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.storeInformation = storeInformation;
    }



    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView type;
        private TextView typeName;
        private ImageView mBtnRightArrow;

        public ViewHolder(Context mContext, View itemView){
            super(itemView);
            type = itemView.findViewById(R.id.type);
            typeName = itemView.findViewById(R.id.type_name);
            mBtnRightArrow = itemView.findViewById(R.id.btn_right_arrow);
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

        if (i == 0){
            text = vh.typeName;
            vh.type.setText("店铺名称");
            vh.typeName.setText(storeInformation.getStoreName());
            vh.mBtnRightArrow.setOnClickListener(this);
            vh.mBtnRightArrow.setTag(i);
        }

        else if (i == 1){
            vh.type.setText("店铺联系人:");
            vh.typeName.setText(storeInformation.getStoreOwner());
            vh.mBtnRightArrow.setOnClickListener(this);
            vh.mBtnRightArrow.setTag(i);
        }
        else if (i == 2){
            vh.type.setText("联系电话:");
            vh.typeName.setText(storeInformation.getPhone());
            vh.mBtnRightArrow.setOnClickListener(this);
            vh.mBtnRightArrow.setTag(i);

        }
        else if(i == 3){
            vh.type.setText("店铺地址:");
            vh.typeName.setText(storeInformation.getStoreAddress());
            vh.mBtnRightArrow.setOnClickListener(this);
            vh.mBtnRightArrow.setTag(i);
        }
        else if (i == 4){
            vh.type.setText("行业:");
            vh.typeName.setText(storeInformation.getType());
            vh.mBtnRightArrow.setOnClickListener(this);
            vh.mBtnRightArrow.setTag(i);
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_right_arrow:
                final EditText editText = new EditText(mContext);

                AlertDialog.Builder input = new AlertDialog.Builder(mContext);
                switch ((int)v.getTag()){
                    case 0:
                        input.setTitle("请输入店铺名称").setView(editText);
                        input.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                text.setText(editText.getText().toString());
                            }
                        }).show();
                        break;

                    case 1:
                        input.setTitle("请输入店铺联系人").setView(editText);
                        input.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                text.setText(editText.getText().toString());
                            }
                        }).show();
                        break;

                    case 2:
                        input.setTitle("请输入联系电话").setView(editText);
                        input.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                text.setText(editText.getText().toString());
                            }
                        }).show();
                        break;

                    case 3:
                        input.setTitle("请输入店铺地址").setView(editText);
                        input.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                text.setText(editText.getText().toString());
                            }
                        }).show();
                        break;

                    case 4:
                        input.setTitle("请输入行业").setView(editText);
                        input.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                text.setText(editText.getText().toString());
                            }
                        }).show();
                        break;
                }
                break;
        }
    }



    @Override
    public int getItemCount() {
        return ITEM_COUNT;
    }


}
