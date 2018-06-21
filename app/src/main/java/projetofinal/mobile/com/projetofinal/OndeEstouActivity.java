package projetofinal.mobile.com.projetofinal;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class OndeEstouActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback, OnMapReadyCallback {
    private int READ_GPS_REQUEST_CODE = 0;
    private Location location;
    private LocationManager locationManager;
    private MapView mapa;
    private GoogleMap mapGoogle;
    private double latitude;
    private double longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onde_estou);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(OndeEstouActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    READ_GPS_REQUEST_CODE);
        }

        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            latitude = location.getLatitude();
            longitude = location.getLongitude();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapGoogle = googleMap;
        LatLng localizacao = new LatLng(latitude, longitude);
        mapGoogle.addMarker(new MarkerOptions().position(localizacao).title("Estou aqui!"));
        mapGoogle.moveCamera(CameraUpdateFactory.newLatLng(localizacao));

    }
}
