package com.example.alliance.user.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.alliance.R;
import com.example.alliance.base.BaseFragment;

public class DeliveryRecordFragment extends BaseFragment {

    private TextView needToPay;
    private TextView lastWeekCount_1;
    private TextView lastWeekPrice_1;
    private TextView lastMonthCount_1;
    private TextView lastMonthPrice_1;
    private TextView thisWeekCount_1;
    private TextView thisWeekPrice_1;
    private TextView thisMonthCount_1;
    private TextView thisMonthPrice_1;

    private TextView lastWeekCount_2;
    private TextView lastWeekPrice_2;
    private TextView lastMonthCount_2;
    private TextView lastMonthPrice_2;
    private TextView thisWeekCount_2;
    private TextView thisWeekPrice_2;
    private TextView thisMonthCount_2;
    private TextView thisMonthPrice_2;


    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.user_delivery_record_layout,null);
        setTextView(view);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
    }

    public void setTextView(View view){
        needToPay = view.findViewById(R.id.need_to_pay);

        lastWeekCount_1 = view.findViewById(R.id.last_week_count_1);
        lastWeekPrice_1 = view.findViewById(R.id.last_week_price_1);

        lastMonthCount_1 = view.findViewById(R.id.last_month_count_1);
        lastMonthPrice_1 = view.findViewById(R.id.last_month_price_1);

        thisWeekCount_1 = view.findViewById(R.id.this_week_count_1);
        thisWeekPrice_1 = view.findViewById(R.id.this_week_price_1);

        thisMonthCount_1 = view.findViewById(R.id.this_month_count_1);
        thisMonthPrice_1 = view.findViewById(R.id.this_month_price_1);


        lastWeekCount_2 = view.findViewById(R.id.last_week_count_2);
        lastWeekPrice_2 = view.findViewById(R.id.last_week_price_2);

        lastMonthCount_2 = view.findViewById(R.id.last_month_count_2);
        lastMonthPrice_2 = view.findViewById(R.id.last_month_price_2);

        thisWeekCount_2 = view.findViewById(R.id.this_week_count_2);
        thisWeekPrice_2 = view.findViewById(R.id.this_week_price_2);

        thisMonthCount_2 = view.findViewById(R.id.this_month_count_2);
        thisMonthPrice_2 = view.findViewById(R.id.this_month_price_2);


    }
}
