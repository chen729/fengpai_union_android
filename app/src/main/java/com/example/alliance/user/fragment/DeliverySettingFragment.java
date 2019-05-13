package com.example.alliance.user.fragment;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.Projection;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.example.alliance.R;
import com.example.alliance.base.BaseFragment;
import java.util.ArrayList;
import java.util.List;


/**
 * 配送设置界面
 * 在201905111511这个时间添加了高德地图的功能
 * update by jack
 */
public class DeliverySettingFragment extends BaseFragment implements View.OnClickListener{

    private EditText deliveryRange;
    private EditText startingPrice;
    private Button mBtnSave;


    ////下面变量是高德地图相关内容
    private MapView mMapView;
    private AMap mAMap;
    private Marker centerMarker;
    private MarkerOptions markerOption = null;
    private BitmapDescriptor ICON_YELLOW = BitmapDescriptorFactory
            .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW);
    private List<Marker> markerList = new ArrayList<Marker>();
    private LatLng centerLatLng = null;// 中心点坐标

    /**
     * 用于显示当前的位置
     * <p>
     * 示例中是为了显示当前的位置，在实际使用中，单独的地理围栏可以不使用定位接口
     * </p>
     */
    private AMapLocationClient mlocationClient;
    private LocationSource.OnLocationChangedListener mListener;
    private AMapLocationClientOption mLocationOption;



    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.user_delivery_setting_layout,null);
        deliveryRange = view.findViewById(R.id.range);
        startingPrice = view.findViewById(R.id.starting_price);
        mBtnSave = view.findViewById(R.id.btn_save);
        setOnClick();
        initMap(DeliverySettingFragment.this.getArguments(),view);////初始化地图
        return view;
    }


    @Override
    protected void initData() {
        super.initData();
        String range = deliveryRange.getText().toString();
        String price = startingPrice.getText().toString();
    }

    public void setOnClick(){
        mBtnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_save:
                Toast.makeText(mContext,"保存",Toast.LENGTH_LONG).show();
                break;
        }
    }



    /////////////////////////////////////////以下内容是高德地图相关////////////////////////////////////////////////
    ////初始化地图
    private void initMap(Bundle savedInstanceState,View view){
        mMapView = (MapView) view.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);           ////// 此方法须覆写，虚拟机需要在很多情况下保存地图绘制的当前状态。
        if (mAMap == null) {
            mAMap = mMapView.getMap();
            mAMap.getUiSettings().setRotateGesturesEnabled(false);   ///关闭旋转手势
            mAMap.getUiSettings().setZoomControlsEnabled(false);     ///关闭放大缩小按钮
            mAMap.moveCamera(CameraUpdateFactory.zoomBy(6));     ////不带地图视角移动动画的方法
            mAMap.getUiSettings().setAllGesturesEnabled(false); // 禁止通过手势移动地图
            mAMap.getUiSettings().setTiltGesturesEnabled(false);// 禁止通过手势倾斜地图
//               mAMap.showIndoorMap(true);       ////显示室内地图
//            setUpMap();

            addMarkersToMap();
        }
    }

    /**
     * 设置一些amap的属性
     */
    private void setUpMap() {
        mAMap.setOnMapClickListener(onMapClick);
//        mAMap.setLocationSource(locationSource);// 设置定位监听   此处根据业务情况使用
       /* // 自定义系统定位蓝点
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        // 自定义定位蓝点图标
        myLocationStyle.myLocationIcon( BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher_foreground));
        // 自定义精度范围的圆形边框颜色
        myLocationStyle.strokeColor(Color.argb(0, 0, 0, 0));
        // 自定义精度范围的圆形边框宽度
        myLocationStyle.strokeWidth(0);
        // 设置圆形的填充颜色
        myLocationStyle.radiusFillColor(Color.argb(0, 0, 0, 0));
        // 将自定义的 myLocationStyle 对象添加到地图上
        mAMap.setMyLocationStyle(myLocationStyle);*/
        mAMap.setMyLocationEnabled(true);// 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        mAMap.setInfoWindowAdapter(infoWindowAdapter);
        // 设置定位的类型为定位模式 ，可以由定位、跟随或地图根据面向方向旋转几种
//        mAMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);           ////自动定位获取当前位置

//        addMarkersToMap();      ////在地图上添加marker 覆盖物
    }

    //////此处用于调试用，到时候要删除 切记  , ,
    LatLng SHANGHAI = new LatLng(24.293519, 116.120909);// 梅江区强民路17附近
    /**
     * 在地图上添加marker
     */
    private void addMarkersToMap() {

        /*//当改变 Marker 的 title 和 snippet 属性时，再次调用 showInfoWindow()，可以更新 InfoWindow 显示内容
        Marker marker = mAMap.addMarker(new MarkerOptions()
//                .title("好好学习")
                .snippet("配送范围：10555 公里/KM")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .draggable(true));
//        marker.setRotateAngle(90);// 设置marker旋转90度
//        marker.setPositionByPixels(500, 500);
        marker.setPosition(SHANGHAI);
        marker.showInfoWindow();// 设置默认显示一个infowinfow*/


        // 设置当前地图显示为当前位置
        mAMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SHANGHAI, 19));
        markerOption = new MarkerOptions();
        markerOption.position(SHANGHAI);
        markerOption.snippet("配送范围：10555 公里/KM");
        markerOption.draggable(false);       ////覆盖物是否可拖动
        markerOption.icon(
                // BitmapDescriptorFactory
                // .fromResource(R.drawable.location_marker)
                BitmapDescriptorFactory.fromBitmap(BitmapFactory
                        .decodeResource(getResources(),
                                R.mipmap.ic_launcher)));
        // 将Marker设置为贴地显示，可以双指下拉看效果
        markerOption.setFlat(false);
        AMapOptions aOptions = new AMapOptions();
        Marker marker = mAMap.addMarker(markerOption);
        marker.showInfoWindow();// 设置默认显示一个infowinfow





       /* ArrayList<BitmapDescriptor> giflist = new ArrayList<BitmapDescriptor>();
        giflist.add(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        giflist.add(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_RED));
        giflist.add(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));

        MarkerOptions markerOption1 = new MarkerOptions().anchor(0.5f, 0.5f)
                .position(Constants.CHENGDU).title("成都市")
                .snippet("成都市:30.679879, 104.064855").icons(giflist)
                .draggable(true).period(10);
        ArrayList<MarkerOptions> markerOptionlst = new ArrayList<MarkerOptions>();
        markerOptionlst.add(markerOption);
        markerOptionlst.add(markerOption1);
        List<Marker> markerlst = aMap.addMarkers(markerOptionlst, true);
        marker2 = markerlst.get(0);

        marker3 = aMap.addMarker(new MarkerOptions().position(
                Constants.ZHENGZHOU).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));*/
    }


    /**
     * marker点击时跳动一下
     */
    public void jumpPoint(final Marker marker) {
        final Handler handler = new Handler();
        final long start = SystemClock.uptimeMillis();
        Projection proj = mAMap.getProjection();
        Point startPoint = proj.toScreenLocation(SHANGHAI);
        startPoint.offset(0, -100);
        final LatLng startLatLng = proj.fromScreenLocation(startPoint);
        final long duration = 1500;

        final Interpolator interpolator = new BounceInterpolator();
        handler.post(new Runnable() {
            @Override
            public void run() {
                long elapsed = SystemClock.uptimeMillis() - start;
                float t = interpolator.getInterpolation((float) elapsed
                        / duration);
                double lng = t * SHANGHAI.longitude + (1 - t)
                        * startLatLng.longitude;
                double lat = t * SHANGHAI.latitude + (1 - t)
                        * startLatLng.latitude;
                marker.setPosition(new LatLng(lat, lng));
                if (t < 1.0) {
                    handler.postDelayed(this, 16);
                }
            }
        });
    }


    AMap.OnMapClickListener onMapClick = new AMap.OnMapClickListener() {        ////定图的点击事件
        @Override
        public void onMapClick(LatLng latLng) {
//            markerOption.icon(ICON_YELLOW);
//            centerLatLng = latLng;
//            addCenterMarker(centerLatLng);
//            Toast.makeText(DeliverySettingFragment.this.getContext(),"选中的坐标：" + centerLatLng.longitude + "," + centerLatLng.latitude,Toast.LENGTH_SHORT).show();
        }
    };


    // 设置定位监听  高德地图监听事件
    /*LocationSource locationSource = new LocationSource() {
        @Override
        public void activate(OnLocationChangedListener onLocationChangedListener) {
            mListener = onLocationChangedListener;
            if (mlocationClient == null) {
                mlocationClient = new AMapLocationClient(DeliverySettingFragment.this.getContext());
                mLocationOption = new AMapLocationClientOption();
                // 设置定位监听
                mlocationClient.setLocationListener(aMaplocListener);
                // 设置为高精度定位模式
                mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
                // 只是为了获取当前位置，所以设置为单次定位
                mLocationOption.setOnceLocation(true);
                // 设置定位参数
                mlocationClient.setLocationOption(mLocationOption);
                mlocationClient.startLocation();
            }
        }

        @Override
        public void deactivate() {
            mListener = null;
            if (mlocationClient != null) {
                mlocationClient.stopLocation();
                mlocationClient.onDestroy();
            }
            mlocationClient = null;
        }
    };*/

    AMapLocationListener aMaplocListener = new AMapLocationListener() {     //声明定位回调监听器
        @Override
        public void onLocationChanged(AMapLocation amapLocation) {
            if (mListener != null && amapLocation != null) {
                String errText = "";
                if (amapLocation != null && amapLocation.getErrorCode() == 0) {
                    mListener.onLocationChanged(amapLocation);// 显示系统小蓝点
                    errText = amapLocation.getAddress();
                } else {
                    errText = "定位失败," + amapLocation.getErrorCode() + ": "
                            + amapLocation.getErrorInfo();
                }
                Toast.makeText(DeliverySettingFragment.this.getContext(),errText+amapLocation.getAddress(),Toast.LENGTH_LONG).show();
            }
        }
    };




    private void addCenterMarker(LatLng latlng) {      /////添加覆盖物
        if(null == centerMarker){
            centerMarker = mAMap.addMarker(markerOption);       ////添加覆盖物
        }
        centerMarker.setPosition(latlng);           /////设置坐标
        centerMarker.setVisible(true);              ////显示覆盖物
        markerList.add(centerMarker);
    }

    AMap.InfoWindowAdapter infoWindowAdapter = new AMap.InfoWindowAdapter() {
        /**
         * 监听自定义infowindow窗口的infowindow事件回调
         */
        @Override
        public View getInfoWindow(Marker marker) {

            View infoWindow = getLayoutInflater().inflate( R.layout.custom_info_window, null);
            render(marker, infoWindow);

            return infoWindow;
        }

        /**
         * 监听自定义infowindow窗口的infocontents事件回调
         */
        @Override
        public View getInfoContents(Marker marker) {
            View infoContent = getLayoutInflater().inflate( R.layout.custom_info_contents, null);
            render(marker, infoContent);
            return infoContent;
        }
    };


    /**
     * 自定义infowinfow窗口
     */
    public void render(Marker marker, View view) {
        String title = marker.getTitle();
        TextView titleUi = ((TextView) view.findViewById(R.id.title));
        if (title != null) {
            SpannableString titleText = new SpannableString(title);
            titleText.setSpan(new ForegroundColorSpan(Color.GRAY), 0, titleText.length(), 0);
            titleUi.setTextSize(15);
            titleUi.setText(titleText);
        } else {
            titleUi.setText("");
        }
        String snippet = marker.getSnippet();
        TextView snippetUi = ((TextView) view.findViewById(R.id.snippet));
        if (snippet != null) {
            SpannableString snippetText = new SpannableString(snippet);
            snippetText.setSpan(new ForegroundColorSpan(Color.GRAY), 0,
                    snippetText.length(), 0);
            snippetUi.setTextSize(15);
            snippetUi.setText(snippetText);
        } else {
            snippetUi.setText("");
        }
    }




    /**
     * 停止定位
     */
    public void deactivate() {
        mListener = null;
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
            mlocationClient.onDestroy();
        }
        mlocationClient = null;
    }


    @Override
    public void onResume() {
        super.onResume();
        if(mMapView != null)    //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
            mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mMapView != null)        //在activity执行onPause时执行mMapView.onPause ()，重新绘制加载地图
            mMapView.onPause();
        deactivate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mMapView != null)        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
            mMapView.onDestroy();
        if(null != mlocationClient){
            mlocationClient.onDestroy();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        if(mMapView != null)
            mMapView.onSaveInstanceState(outState);
    }
}
