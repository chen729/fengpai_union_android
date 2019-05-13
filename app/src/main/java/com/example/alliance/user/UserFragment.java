package com.example.alliance.user;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.alliance.R;
import com.example.alliance.base.BaseFragment;
import com.example.alliance.base.ItemDecoration;
import com.example.alliance.user.activity.DeliverySettingActivity;
import com.example.alliance.user.activity.LoginOutActivity;
import com.example.alliance.user.activity.MessageRecordActivity;
import com.example.alliance.user.activity.StoreInformationActivity;
import com.example.alliance.user.activity.StoreSettingActivity;
import com.example.alliance.user.activity.UserInformationActivity;
import com.example.alliance.user.adapter.UserRecyclerViewAdapter;
import com.example.alliance.user.base.Item;
import java.util.ArrayList;
import java.util.List;
/*
    个人中心 Fragment
    包括一个cardView的名片的跳转
    5个点击跳转页面 “信息记录”“店铺记录”“配送设置”“店铺设置”“退出登录”
*/

public class UserFragment extends BaseFragment implements View.OnClickListener{

    private CardView mCardView;
    private RecyclerView mRecyclerView;
    private UserRecyclerViewAdapter adapter;

    private List<Item> list = new ArrayList<>();

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.user_layout,null);
        mCardView = view.findViewById(R.id.card_view);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        setItem();
        mCardView.setOnClickListener(this);
        setRecyclerView();

    }

    public void setRecyclerView(){
        adapter = new UserRecyclerViewAdapter(mContext,list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,1));
        mRecyclerView.addItemDecoration(new ItemDecoration(1));
        adapter.setOnItemClick(new UserRecyclerViewAdapter.OnItemClick() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        startActivity(new Intent(mContext, MessageRecordActivity.class));       /////信息记录
                        break;
                    case 1:
                        startActivity(new Intent(mContext, StoreInformationActivity.class));    ////店铺信息
                        break;
                    case 2:
                        startActivity(new Intent(mContext, DeliverySettingActivity.class));     ///配送设置
                        break;
                    case 3:
                        startActivity(new Intent(mContext, StoreSettingActivity.class));        ///店铺设置
                        break;
                    case 4:
                        startActivity(new Intent(mContext, LoginOutActivity.class));            ///退出登录
                        break;
                    default:
                        break;
                }
            }
        });
        mRecyclerView.setAdapter(adapter);
    }

    public void setItem(){
        Item messageRecord = new Item(R.mipmap.message_record,"信息记录");
        list.add(messageRecord);
        Item storeInformation = new Item(R.mipmap.store_information,"店铺信息");
        list.add(storeInformation);
        Item deliverySetting = new Item(R.mipmap.delivery_setting,"配送设置");
        list.add(deliverySetting);
        Item storeSetting = new Item(R.mipmap.store_setting,"店铺设置");
        list.add(storeSetting);
        Item loginOut = new Item(R.mipmap.login_out,"退出登录");
        list.add(loginOut);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.card_view:
                startActivity(new Intent(mContext, UserInformationActivity.class));
                break;
        }
    }
}
