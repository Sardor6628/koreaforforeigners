package com.example.ibrokhimov.draft_final;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
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

        // Add a marker in Sydney and move the camera
        LatLng n1 = new LatLng(35.4833, 129.1244);
        mMap.addMarker(new MarkerOptions().position(n1).title("Poseokjeong Pavilion Site of Gyeongju"));
        LatLng n2 = new LatLng(35.1347, 128.5242);
        mMap.addMarker(new MarkerOptions().position(n2).title("Bonghwangdong Archaeological Site of Gimhae"));
        LatLng n3 = new LatLng(37.1719, 127.0051);
        mMap.addMarker(new MarkerOptions().position(n3).title("Hwaseong Fortress of Suwon"));
        LatLng n4 = new LatLng(36.1145, 126.5400);
        mMap.addMarker(new MarkerOptions().position(n4).title("Garimseong Fortress in Buyeo"));
        LatLng n5 = new LatLng(36.1718, 126.5445);
        mMap.addMarker(new MarkerOptions().position(n5).title("Busosanseong Fortress of Buyeo"));
        LatLng n6 = new LatLng(35.4833, 129.1244);
        mMap.addMarker(new MarkerOptions().position(n6).title("Hwangnyongsa Temple Site of Gyeongju"));
        LatLng n7= new LatLng(35.5016, 129.1356);
        mMap.addMarker(new MarkerOptions().position(n7).title("Mangdeoksa Temple Site of Gyeongju"));
        LatLng n8 = new LatLng(35.4908, 129.1432);
        mMap.addMarker(new MarkerOptions().position(n8).title("Sacheonwangsa Temple Site of Gyeongju"));
        LatLng n9 = new LatLng(35.4915, 129.1432);
        mMap.addMarker(new MarkerOptions().position(n9).title("Seoul Fortress Walls"));
        LatLng n10 = new LatLng(37.3149, 127.0658);
        mMap.addMarker(new MarkerOptions().position(n10).title("Pungnap-dong Toseong Fortress in Seoul"));
        LatLng n11 = new LatLng(36.2735, 127.0745);
        mMap.addMarker(new MarkerOptions().position(n11).title("Gongsanseong Fortress of Gongju"));
        LatLng n12= new LatLng(36.2739, 1270646);
        mMap.addMarker(new MarkerOptions().position(n12).title("Songsalli Ancient Tombs of Gongju"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(n1));
    }
}
