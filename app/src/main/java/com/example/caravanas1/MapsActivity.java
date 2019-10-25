package com.example.caravanas1;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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
        LatLng ifpe = new LatLng(-8.0596, -34.9505);
        LatLng ufrpe = new LatLng(-8.0174, -34.9492);
        LatLng ufpe = new LatLng(-8.0517, -34.9507);
        mMap.addMarker( new MarkerOptions().
                position(ifpe).
                title("IFPE").
                icon(BitmapDescriptorFactory.defaultMarker(35)));

        mMap.addMarker( new MarkerOptions().
                position(ufrpe).
                title("UFRPE").
                icon(BitmapDescriptorFactory.defaultMarker(120)));

        mMap.addMarker( new MarkerOptions().
                position(ufpe).
                title("UFPE").

                icon(BitmapDescriptorFactory.defaultMarker(230)));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(ifpe));
    }
}
