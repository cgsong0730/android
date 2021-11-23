package com.example.map;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.map.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    private static final LatLng seoul = new LatLng(37.566535, 126.97769);
    private static final LatLng daejeon = new LatLng(36.50412, 127.384548);
    private static final LatLng busan = new LatLng(35.179554, 129.075642);

    private Marker mSeoul;
    private Marker mDaejeon;
    private Marker mBusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mSeoul = mMap.addMarker(new MarkerOptions().position(seoul).title("seoul"));
        mSeoul.setTag(0);

        mDaejeon = mMap.addMarker(new MarkerOptions().position(daejeon).title("daejeon"));
        mDaejeon.setTag(0);

        mBusan = mMap.addMarker(new MarkerOptions().position(busan).title("busan"));
        mBusan.setTag(0);

        mMap.setOnMarkerClickListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(37.566535, 126.97769)));
        mMap.setMinZoomPreference(7);
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {

        Integer clickCount = (Integer) marker.getTag();

        if(clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(this, marker.getTitle()+" 마커가 클릭되었습니다. (" + clickCount +")", Toast.LENGTH_SHORT).show();
        }

        return false;
    }
}
