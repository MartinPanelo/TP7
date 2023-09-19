package com.martintecno.tp7.ui.home;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class HomeViewModel extends AndroidViewModel {

    private Context context;
    LatLng UbicacionActual =new LatLng(0,0);
    private FusedLocationProviderClient FusedLPC;

  //  private MutableLiveData<Location> LocationM;

    private MutableLiveData<MapaActual> MAMutable;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        this.context = application;
        FusedLPC = LocationServices.getFusedLocationProviderClient(context);
    }

 /*   public LiveData<Location> getLocationM() {
        if (LocationM == null) {
            LocationM = new MutableLiveData<>();
        }
        return LocationM;
    }*/
    public LiveData<MapaActual> getMapa(){
        if(MAMutable == null){
            MAMutable = new MutableLiveData<>();
        }
        return MAMutable;
    }
    public void ObtenerMapa(){

        MapaActual MA = new MapaActual();
        MAMutable.setValue(MA);
    }


    public class MapaActual implements OnMapReadyCallback {




        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            googleMap.addMarker(new MarkerOptions().position(UbicacionActual).title("ACA ESTOY!!"));


            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(UbicacionActual)
                    .zoom(19)
                    .bearing(45)
                    .tilt(70)
                    .build();

            CameraUpdate Cupdate = CameraUpdateFactory.newCameraPosition(cameraPosition);

            googleMap.animateCamera(Cupdate);
        }
    }



    public void LecturaPermanente() {

        LocationRequest request = LocationRequest.create();

        request.setInterval(5000);
        request.setFastestInterval(5000);
        request.setPriority(Priority.PRIORITY_HIGH_ACCURACY);

        LocationCallback locationCK = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {

                if (locationResult != null) {

                    Location locationActual = locationResult.getLastLocation();

                    UbicacionActual = new LatLng(locationActual.getLatitude(),locationActual.getLongitude());

                    ObtenerMapa();

               //     LocationM.postValue(locationActual);
                }

            }
        };
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        FusedLPC.requestLocationUpdates(request, locationCK, null);

    }

}