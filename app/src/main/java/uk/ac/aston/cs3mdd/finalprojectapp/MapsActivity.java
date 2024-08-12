package uk.ac.aston.cs3mdd.finalprojectapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    FrameLayout map;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        map = findViewById(R.id.map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.gMap = googleMap;
        gMap.getUiSettings().setZoomControlsEnabled(true);

        LatLng mapBrandsHatch = new LatLng(51.355697, 0.262515);
        this.gMap.addMarker(new MarkerOptions().position(mapBrandsHatch).title("Brands Hatch"));
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(mapBrandsHatch));

        LatLng mapDonnington = new LatLng(52.8295, -1.3815);
        this.gMap.addMarker(new MarkerOptions().position(mapDonnington).title("Donnington Park"));
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(mapDonnington));

        LatLng mapSnetterton = new LatLng(52.463629, 0.945977);
        this.gMap.addMarker(new MarkerOptions().position(mapSnetterton).title("Snetterton"));
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(mapSnetterton));

        LatLng mapThruxton = new LatLng(51.206081, -1.608573);
        this.gMap.addMarker(new MarkerOptions().position(mapThruxton).title("Thruxton"));
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(mapThruxton));

        LatLng mapOultonPark = new LatLng(53.181105, -2.616491);
        this.gMap.addMarker(new MarkerOptions().position(mapOultonPark).title("Oulton park"));
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(mapOultonPark));

        LatLng mapCroft = new LatLng(54.458376, -1.555028);
        this.gMap.addMarker(new MarkerOptions().position(mapCroft).title("Croft"));
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(mapCroft));

        LatLng mapKnockhill = new LatLng(56.131414, -3.508797);
        this.gMap.addMarker(new MarkerOptions().position(mapKnockhill).title("Knockhill"));
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(mapKnockhill));

        LatLng mapSilverstone = new LatLng(52.069331, -1.021678);
        this.gMap.addMarker(new MarkerOptions().position(mapSilverstone).title("Silverstone"));
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(mapSilverstone));
    }


}