package com.example.course;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.course.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    private static final LatLng seoul = new LatLng(37.566535, 126.97769);
    private static final LatLng daejeon = new LatLng(36.50412, 127.384548);
    private static final LatLng busan = new LatLng(35.179554, 129.075642);

    private LatLng before = new LatLng(37.566535, 126.97769);
    private LatLng current = new LatLng(37.566535, 126.97769);

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

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);

        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                current = new LatLng(location.getLatitude(), location.getLongitude());
            }
            public void onStatusChanged(String provider, int status, Bundle extras) {}
            public void onProviderEnabled(String provider) {}
            public void onProviderDisabled(String provider) {}
        }; // of locationListener

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
            Toast.makeText(MapsActivity.this, "First enable LOCATION ACCESS in settings.", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);

            return;
        }


        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, locationListener);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, locationListener);
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

//        mMap.setMinZoomPreference(7);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(7));
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

    public void zoomIn(View v) {
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
    } // of zoomIn

    public void zoomOut(View v) {
        mMap.animateCamera(CameraUpdateFactory.zoomOut());
    } // of zoomIn

    public void addMarker(View v) {
        mMap.addMarker(new MarkerOptions().position(current).title("current"));
        PolylineOptions polyline = new PolylineOptions().add(before, current);
        mMap.addPolyline(polyline);
        before = current;
    } // of addMarker
}
