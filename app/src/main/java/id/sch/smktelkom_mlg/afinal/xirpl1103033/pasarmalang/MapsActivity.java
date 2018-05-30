package id.sch.smktelkom_mlg.afinal.xirpl1103033.pasarmalang;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
        , GoogleMap.OnMyLocationButtonClickListener
        , GoogleMap.OnMyLocationClickListener {

    public GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Add a marker in Sawojajar Traditional Market and move the camera
        LatLng sawojajar = new LatLng(-7.974963, 112.660750);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sawojajar, 20));
        MarkerOptions marker1 = new MarkerOptions().title("Sawojajar Traditional Market").position(sawojajar);
        mMap.addMarker(marker1);

        // Add a marker in Pasar Oro-Oro Dowo  and move the camera
        LatLng orooro = new LatLng(-7.968651, 112.628225);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(orooro, 20));
        MarkerOptions marker2 = new MarkerOptions().title("Pasar Oro-Oro Dowo").position(orooro);
        mMap.addMarker(marker2);

        // Add a marker in Pasar Madyopuro  and move the camera
        LatLng madyopuro = new LatLng(-7.974097, 112.671216);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(madyopuro, 20));
        MarkerOptions marker3 = new MarkerOptions().title("Pasar Madyopuro").position(madyopuro);
        mMap.addMarker(marker3);

        // Add a marker in Pasar Klojen  and move the camera
        LatLng klojen = new LatLng(-7.972863, 112.636857);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(klojen, 20));
        MarkerOptions marker4 = new MarkerOptions().title("Klojen Traditional Market").position(klojen);
        mMap.addMarker(marker4);

        // Add a marker in Pasar Besar Kota Malang and move the camera
        LatLng besar = new LatLng(-7.987731, 112.633016);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(besar, 20));
        MarkerOptions marker5 = new MarkerOptions().title("Pasar Besar Kota Malang").position(besar);
        mMap.addMarker(marker5);

        // Add a marker in Pasar Kebalen and move the camera
        LatLng kebalen = new LatLng(-7.987932, 112.636892);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kebalen, 20));
        MarkerOptions marker6 = new MarkerOptions().title("Pasar Kebalen").position(kebalen);
        mMap.addMarker(marker6);

        // Add a marker in Pasar Velodrom and move the camera
        LatLng velodrom = new LatLng(-7.973760, 112.669340);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(velodrom, 20));
        MarkerOptions marker7 = new MarkerOptions().title("Pasar Velodrom").position(velodrom);
        mMap.addMarker(marker7);

        // Add a marker in Pasar Bunul Rejo Malang and move the camera
        LatLng bunul = new LatLng(-7.972571, 112.646166);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bunul, 20));
        MarkerOptions marker8 = new MarkerOptions().title("Pasar Bunul Rejo Malang").position(bunul);
        mMap.addMarker(marker8);

        // Add a marker in Pasar Tawangmangu and move the camera
        LatLng tawang = new LatLng(-7.959851, 112.631278);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tawang, 20));
        MarkerOptions marker9 = new MarkerOptions().title("Pasar Tawangmangu").position(tawang);
        mMap.addMarker(marker9);

        // Add a marker in Blimbing Traditional Market and move the camera
        LatLng blimbing = new LatLng(-7.940066, 112.639410);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(blimbing, 20));
        MarkerOptions marker10 = new MarkerOptions().title("Blimbing Traditional Market").position(blimbing);
        mMap.addMarker(marker10);

        // Add a marker in Pasar Temboro and move the camera
        LatLng temboro = new LatLng(-7.983545, 112.691939);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(temboro, 20));
        MarkerOptions marker11 = new MarkerOptions().title("Pasar Temboro").position(temboro);
        mMap.addMarker(marker11);

        // Add a marker in Pasar Sukun and move the camera
        LatLng sukun = new LatLng(-7.997171, 112.619941);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sukun, 20));
        MarkerOptions marker12 = new MarkerOptions().title("Pasar Sukun").position(sukun);
        mMap.addMarker(marker12);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    mMap.setMyLocationEnabled(true);
                }
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "My Location Button Clicked", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Lokasiku saat ini : " + location, Toast.LENGTH_LONG).show();
    }
}