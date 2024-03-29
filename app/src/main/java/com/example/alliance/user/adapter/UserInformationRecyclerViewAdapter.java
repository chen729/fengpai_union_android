package com.example.alliance.user.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alliance.R;
import com.example.alliance.user.activity.AvatarActivity;
import com.example.alliance.user.activity.UserNameActivity;
import com.example.alliance.user.base.UserInformation;


public class UserInformationRecyclerViewAdapter extends RecyclerView.Adapter implements View.OnClickListener{

    private int current = 1;
    private static final int HEADER_ITEM = 0;
    private static final int NORMAL = 1;

    private static final int ITEM_COUNT = 5;


    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private UserInformation user;


    public UserInformationRecyclerViewAdapter(Context mContext, UserInformation user) {
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.user = user;
    }

    @Override
    public int getItemViewType(int position) {
       if (position == 0){
           return HEADER_ITEM;
       }
       else{
           return NORMAL;
       }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder{

        private ImageView avatar;

        public HeaderViewHolder(Context mContext, View itemView){
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout rlItem;          ////用于整行的点击事件
        private RelativeLayout mRelativeLayout_1;
        private RelativeLayout mRelativeLayout_2;
        private TextView type;
        private TextView typeName;
        private ImageView mBtnRightArrow;

        public ViewHolder(Context mContext, View itemView){
            super(itemView);
            rlItem = itemView.findViewById(R.id.rlItem);////用于整行的点击事件
            mRelativeLayout_1 = itemView.findViewById(R.id.part_1);
            mRelativeLayout_2 = itemView.findViewById(R.id.part_2);
            type = itemView.findViewById(R.id.type);
            typeName = itemView.findViewById(R.id.type_name);
            mBtnRightArrow = itemView.findViewById(R.id.btn_right_arrow);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == HEADER_ITEM){
            return new HeaderViewHolder(mContext,mLayoutInflater.inflate(R.layout.user_information_item_header_layout,null));
        }
        return new ViewHolder(mContext,mLayoutInflater.inflate(R.layout.user_information_item_layout,null));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        /*if (i == 0){
            HeaderViewHolder vh = (HeaderViewHolder)viewHolder;
            vh.avatar.setImageResource(user.getAvatar());
            vh.avatar.setOnClickListener(this);
        }
        else if (i == 1){
            ViewHolder vh = (ViewHolder)viewHolder;
            vh.type.setText("员工姓名:");
            SharedPreferences pre = mContext.getSharedPreferences("user_info",Context.MODE_PRIVATE);
            String name = pre.getString("userName","");
            if (name == null){
                vh.typeName.setText(user.getName());
            }
            else{
                vh.typeName.setText(name);
            }
            vh.mBtnRightArrow.setOnClickListener(this);
            vh.mBtnRightArrow.setTag(i);
        }
        else if (i == 2){
            ViewHolder vh = (ViewHolder)viewHolder;
            vh.type.setText("员工手机:");
            vh.typeName.setText(user.getPhone());
            vh.mRelativeLayout_2.setVisibility(View.GONE);
        }
        else if(i == 3){
            ViewHolder vh = (ViewHolder)viewHolder;
            vh.type.setText("员工角色:");
            vh.typeName.setText(user.getCharacter());
            vh.mRelativeLayout_2.setVisibility(View.GONE);
        }
        else if (i == 4){
            ViewHolder vh = (ViewHolder)viewHolder;
            vh.type.setText("重置密码:");
            vh.mBtnRightArrow.setOnClickListener(this);
            vh.mBtnRightArrow.setTag(i);
            vh.mRelativeLayout_1.setVisibility(View.INVISIBLE);
        }*/

        /////修改后的代码  201905131543   update by jack
        switch (i){
            case 0:
                HeaderViewHolder vh = (HeaderViewHolder)viewHolder;
                vh.avatar.setImageResource(user.getAvatar());
                vh.avatar.setOnClickListener(this);
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                initData(i,viewHolder);
                break;
            default:
                break;
        }
    }


    String[] attrStr = {"员工姓名:","员工手机:","员工角色:","重置密码:"};
    private void initData(int index,RecyclerView.ViewHolder viewHolder){           ////给UI赋值数据
        ViewHolder vh = (ViewHolder)viewHolder;
        vh.rlItem.setTag(index);
        vh.rlItem.setOnClickListener(this);
        String txtStr = "员工姓名:";
        switch (index){
            case 1:
                SharedPreferences pre = mContext.getSharedPreferences("user_info",Context.MODE_PRIVATE);
                String name = pre.getString("userName","");
                if (name == null){
                    vh.typeName.setText(user.getName());
                }
                else{
                    vh.typeName.setText(name);
                }
//                vh.mBtnRightArrow.setOnClickListener(this);
                vh.mBtnRightArrow.setTag(index);
                break;
            case 2:
                vh.typeName.setText(user.getPhone());
                vh.mRelativeLayout_2.setVisibility(View.GONE);
                break;
            case 3:
                vh.typeName.setText(user.getCharacter());
                vh.mRelativeLayout_2.setVisibility(View.GONE);
                break;
            case 4:
                ;
//                vh.mBtnRightArrow.setOnClickListener(this);
                vh.mBtnRightArrow.setTag(index);
                vh.mRelativeLayout_1.setVisibility(View.INVISIBLE);
                break;
            default:
                break;
        }
        if(index <= attrStr.length)          ////注意下标越界
            vh.type.setText(attrStr[index - 1]);
    }


    @Override
    public void onClick(View v) {
        /*switch (v.getId()){
            case R.id.btn_right_arrow:
                if (onItemClick != null){
                    onItemClick.onItemClick(v,(int)v.getTag());
                }
                break;
            case R.id.avatar:
                Intent intent = new Intent(mContext, AvatarActivity.class);
                intent.putExtra("avatar",user.getAvatar());
                mContext.startActivity(intent);
                break;

        }*/

        switch (Integer.parseInt(v.getTag().toString())){
            default:
                if (onItemClick != null){
                    onItemClick.onItemClick(v,(int)v.getTag());
                }
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
