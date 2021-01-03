package com.example.mappz;

import androidx.fragment.app.FragmentActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<LatLng> arrayList = new ArrayList<LatLng>();
    LatLng TechPark = new LatLng(31.484532, 74.282059);
      MediaPlayer mp= new MediaPlayer();



    ArrayList<String> title = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mp = MediaPlayer.create(this, R.raw.mughaleazam);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        arrayList.add(TechPark);
        title.add("Tech Park");
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

        for(int i=0;i<arrayList.size();i++)
        {
            for(int j=0;j<title.size();j++)
            {
                mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title(String.valueOf(title.get(j))));

            }
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));


        }

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String markertitle= marker.getTitle();

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 15));
                mp.start();


                return false;
            }
        });

        //mMap.addMarker(new MarkerOptions().position(TechPark).title("Marker in Tech Park"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(TechPark));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TechPark, 15));


    }
}