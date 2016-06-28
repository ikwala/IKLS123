package ikwala.com;

import android.content.Intent;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static ikwala.com.Variabels.*;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleApiClient.ConnectionCallbacks,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnMarkerDragListener,
        GoogleMap.OnMapLongClickListener{

    private GoogleMap mMap;
    private double longitude;
    private double latitude;
    private GoogleApiClient googleApiClient;
    private Button btnCurrentPos;
    Button btnSatalite;
    Button btnHybred;
    Button btnNormal;
    FloatingActionButton fabCurrentPos;
    IKLSModulator iklsModulator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        iklsModulator = IKLSModulator.getsIKIklsModulator(getApplicationContext());



        orderNumber++;

        btnHybred = (Button)findViewById(R.id.btnHybred);
        btnHybred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });
        btnNormal = (Button)findViewById(R.id.btnNormal);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });
        btnSatalite = (Button)findViewById(R.id.btnSatalite);
        btnSatalite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });

        fabCurrentPos = (FloatingActionButton)findViewById(R.id.fabCurrentPos);
        fabCurrentPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCurrentLocation();
                moveMap();
            }
        });


        btnCurrentPos = (Button) findViewById(R.id.btnCurrentPos);
        btnCurrentPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                locLat = latitude;
                locLong = longitude;
                orderCondition = "New";

                Orders order = new Orders(orderNumber,date,cloth1,numCloth1,cloth2,
                        numCloth2,cloth3,numCloth3,cloth4,numCloth4,specialRequist,locLat,locLong,
                        orderCondition);

                iklsModulator.addOrders(order);


                Toast.makeText(getApplicationContext(),"New Washing Order has been submitted",Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MapsActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });


        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();

        googleApiClient.connect();
        getCurrentLocation();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").draggable(true));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.setOnMarkerDragListener(this);
        mMap.setOnMapLongClickListener(this);
    }

    private void getCurrentLocation() {

        Location location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        if (location!= null)
        {
            longitude = location.getLongitude();
            latitude = location.getLatitude();

            moveMap();
        }
    }

    private void moveMap()
    {
        String msg = "your Current Posetion";

        LatLng latLng = new LatLng(latitude,longitude);

        mMap.clear();

        mMap.addMarker(new MarkerOptions().position(latLng).draggable(true).title("Current Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onConnected(@Nullable Bundle bundle)
    {
        getCurrentLocation();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }



    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

        latitude = marker.getPosition().latitude;
        longitude = marker.getPosition().longitude;

        moveMap();

    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(latLng).draggable(true));

    }
}