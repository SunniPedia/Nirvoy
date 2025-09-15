package com.srizwan01.nirvoy11;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;

import androidx.core.app.ActivityCompat;


/*
 * Author: @koshurboii (Telegram: t.me/koshurboii)
 * Description: GPSLocationProvider class for fetching GPS coordinates.
 * Usage: 
 * 1. Create an instance of GPSLocationProvider by passing a Context, TextView for Latitude, and TextView for Longitude.
 * 2. Call requestLocationUpdates() to start receiving location updates.
 * 3. Call stopLocationUpdates() when location updates are no longer needed.
 */

public class GPSLocationProvider {

    private static final int REQUEST_LOCATION_PERMISSION = 1001;

    private LocationManager locationManager;
    private LocationListener locationListener;
    private Context context;
    private TextView Latitude;
    private TextView Longitude;

    public GPSLocationProvider(Context context, TextView Latitude, TextView Longitude) {
        this.context = context;
        this.Latitude = Latitude;
        this.Longitude = Longitude;

        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                updateLocationTextView(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {}

            @Override
            public void onProviderEnabled(String provider) {}

            @Override
            public void onProviderDisabled(String provider) {}
        };
    }

    public void requestLocationUpdates() {
      
        if (!isLocationEnabled() || !hasLocationPermission()) {
       
              if (!isLocationEnabled()) {
                  
                     showEnableLocationDialog();
           }
                 if (!hasLocationPermission()) {
                     
                   showEnableLocationPDialog();
            }
                   return;
                   
               }

        Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        updateLocationTextView(lastKnownLocation);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
    }

    public void stopLocationUpdates() {
        locationManager.removeUpdates(locationListener);
    }

    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }
    
    private void showEnableLocationPDialog() {
        new AlertDialog.Builder(context)
            .setMessage("Location permission is not granted. Please grant permission to fetch location.")
            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    requestLocationPermission();
                }
            })
            .show();
    }

    private void showEnableLocationDialog() {
        new AlertDialog.Builder(context)
            .setMessage("GPS is not enabled. Please enable GPS to fetch location.")
            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    enableLocation();
                }
            })
            .show();
    }

    private void enableLocation() {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        context.startActivity(intent);
    }

    private boolean hasLocationPermission() {
        return ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestLocationPermission() {
        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
    }

    private void updateLocationTextView(Location location) {
        if (Latitude != null && Longitude != null) {
            if (location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                Latitude.setText(String.valueOf(latitude));
                Longitude.setText(String.valueOf(longitude));
            } else {
                Latitude.setText("Fetching Latitude. Please ensure GPS is enabled and permission is granted, if it is then it may take time to fetch due to GPS signal.");
                Longitude.setText("Fetching Longitude. Please ensure GPS is enabled and permission is granted, if it is then it may take time to fetch due to GPS signal.");
            }
        }
    }
}