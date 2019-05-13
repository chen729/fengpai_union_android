package com.example.alliance.user.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alliance.R;
import com.example.alliance.user.base.Item;

import java.util.List;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter implements View.OnClickListener{

    private static final int ITEM_COUNT = 5;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Item> list;
    private Item item;

    public UserRecyclerViewAdapter(Context mContext, List<Item> list) {
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.list = list;
    }



    class ViewHolder extends RecyclerView.ViewHolder{

        private CardView mCardView;
        private ImageView itemId;
        private TextView itemName;

        public ViewHolder(Context mContext, View itemView){
            super(itemView);
            mCardView = itemView.findViewById(R.id.card_view);
            itemId = itemView.findViewById(R.id.item_id);
            itemName = itemView.findViewById(R.id.item_name);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(mContext,mLayoutInflater.inflate(R.layout.user_item_layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
            ViewHolder vh = (ViewHolder)viewHolder;
            item = list.get(position);
            vh.mCardView.setOnClickListener(this);
            vh.mCardView.setTag(position);
            vh.itemId.setImageResource(item.getItemId());
            vh.itemName.setText(item.getItemName());

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.card_view:
                onItemClick.onItemClick(v,(int)v.getTag());
                break;
        }
    }
    @Override
    public int getItemCount() {
        return ITEM_COUNT;
    }

    public interface OnItemClick{
        void onItemClick(View view,int position);
    }

    private OnItemClick onItemClick;
    public void setOnItemClick(OnItemClick onItemClick){
        this.onItemClick = onItemClick;
    }
}
