package tw.com.gmapdemo;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import tw.com.gmapdemo.databinding.ActivityMaps2Binding;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMaps2Binding binding;

    private LatLng area1 = new LatLng(24.134469,120.6825714);
    private LatLng area2 = new LatLng(24.1378257,120.6835178);
    private LatLng area3 = new LatLng(24.1320321,120.6858532);
    private LatLng area4 = new LatLng(24.1466117,120.6540152);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMaps2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //顯示地圖的樣式
        //MAP_TYPE_NORMAL   基本地圖
        //MAP_TYPE_SATELLITE   衛星地圖
        //MAP_TYPE_HYBRID  道路及標籤的衛星地圖

        //改變地圖的樣式
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);


        //第一種方法
        //標示物件
        MarkerOptions markerOptions = new MarkerOptions();
        //插入標示圖片物件  snippet代表加註說明
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.food);
        markerOptions.position(area1).title("台中肉圓").snippet("超級好吃").icon(bitmapDescriptor);
        //將標示物件放入地圖
        mMap.addMarker(markerOptions);

        //第二種寫法，快速寫法
        mMap.addMarker(new MarkerOptions().position(area2).title("醉月樓").snippet("宮原眼科二樓").icon(BitmapDescriptorFactory.fromResource(R.mipmap.food)));

        mMap.addMarker(new MarkerOptions().position(area3).title("陳明統"));

        //defaultMarker(BitmapDescriptorFactory.HUE_YELLOW) 使用預設變黃色
        mMap.addMarker(new MarkerOptions().position(area4).title("饕之鄉").snippet("平價的鼎泰豐").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        //給經緯度的中心點 ZOOM值越大可見範圍越小
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(area1,14);
        mMap.moveCamera(cameraUpdate);






    }
}