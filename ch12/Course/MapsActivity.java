package com.example.pro2;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.MapsInitializer.Renderer;
import com.google.android.gms.maps.OnMapsSdkInitializedCallback;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback, OnMapsSdkInitializedCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private static final LatLng seoul = new LatLng(37.566535, 126.97769);
    private static final LatLng daejeon = new LatLng(36.50412, 127.384548);
    private static final LatLng busan = new LatLng(35.179554, 129.075642);

    private LatLng before = new LatLng(37.566535, 126.97769);
    private LatLng current = new LatLng(37.566535, 126.97769);

    private Marker mSeoul;
    private Marker mDaejeon;
    private Marker mBusan;

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private static final String[] REQUIRED_PERMISSIONS = new String[] {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.INTERNET
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapsInitializer.initialize(getApplicationContext(), Renderer.LATEST, this);
        setContentView(R.layout.activity_map);

        for (String item : REQUIRED_PERMISSIONS) {
            if (ContextCompat.checkSelfPermission(this, item) == PackageManager.PERMISSION_GRANTED){
                if (mMap != null) {
                    mMap.setMyLocationEnabled(true);
                }
            } else {
                ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, LOCATION_PERMISSION_REQUEST_CODE);
            }
        }

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        } else {
            Log.d("MapsDemo", "Can not find Map Fragment.");
        }

        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                current = new LatLng(location.getLatitude(), location.getLongitude());
            }
            public void onStatusChanged(String provider, int status, Bundle extras) {}
            public void onProviderEnabled(String provider) {}
            public void onProviderDisabled(String provider) {}
        }; // of locationListener

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, locationListener);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 10, locationListener);
    }

    @Override
    public void onMapsSdkInitialized(MapsInitializer.Renderer renderer) {
        switch (renderer) {
            case LATEST:
                Log.d("MapsDemo", "The latest version of the renderer is used.");
                break;
            case LEGACY:
                Log.d("MapsDemo", "The legacy version of the renderer is used.");
                break;
        }
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
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seoul, 12f));

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
