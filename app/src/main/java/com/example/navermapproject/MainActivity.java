package com.example.navermapproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapFragment mapFragment = (com.naver.maps.map.MapFragment)getSupportFragmentManager().findFragmentById(R.id.map);

        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.map,mapFragment).commit();
        }

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        naverMap.setMapType(NaverMap.MapType.Basic);
        naverMap.setSymbolScale(1.5f);

        LatLng latLng1 = new LatLng(37.518012, 127.101966);
        LatLng latLng2 = new LatLng(37.520414, 127.098915);

        CameraUpdate cameraUpdate1 = CameraUpdate.scrollTo(latLng1);
        naverMap.moveCamera(cameraUpdate1);

        CameraUpdate cameraUpdate2 = CameraUpdate.zoomTo(15);
        naverMap.moveCamera(cameraUpdate2);

        Marker marker1 = new Marker();
        marker1.setPosition(latLng1);
        marker1.setMap(naverMap);
        marker1.setSubCaptionText("소프트웨어코딩학원");
        marker1.setSubCaptionColor(Color.BLACK);
        marker1.setSubCaptionHaloColor(Color.BLACK);
        marker1.setSubCaptionTextSize(10);

        InfoWindow infoWindow1 = new InfoWindow();

        infoWindow1.setAdapter(new InfoWindow.DefaultTextAdapter(this) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return "소프트웨어 학원입니당";
            }
        });
        infoWindow1.open(marker1);

        Marker marker2 = new Marker();
        marker2.setPosition(latLng2);
        marker2.setMap(naverMap);

        marker2.setSubCaptionText("우리집이에용");
        marker2.setSubCaptionColor(Color.BLACK);
        marker2.setSubCaptionHaloColor(Color.BLACK);
        marker2.setSubCaptionTextSize(10);

        InfoWindow infoWindow2 =new InfoWindow();
        infoWindow2.setAdapter(new InfoWindow.DefaultTextAdapter(this) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return "우리집";
            }
        });
        infoWindow2.open(marker2);
        }
    }

