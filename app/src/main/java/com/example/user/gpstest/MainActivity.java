package com.example.user.gpstest;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvLocationGPS;

    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLocationGPS = (TextView) findViewById(R.id.tvLocationGPS);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
    }


    protected void onResume(){
        super.onResume();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000*10*10, 10, locationListener);
    }

    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            showLocation(location);
        }
        public void onProviderDisabled(String provider) {
            return;
        }
        public void onProviderEnabled(String provider) {
            return;

        }
        public void onStatusChanged(String provider, int status, Bundle extras) {
            return;
        }

    };
            private void showLocation(Location location) {
                if (location == null)
                    tvLocationGPS.setText("Немає даних про місцезнаходження. Можливо вимкнений GPS");
                if (location.getProvider().equals(LocationManager.GPS_PROVIDER)) {
                    tvLocationGPS.setText(formatLocation(location));
                }

            }

            private String formatLocation(Location location) {
                if (location == null)
                    return "";
                return String.format(
                        "Ваші координати: Широта = %1$.4f, Довгота = %2$.4f", location.getLatitude(), location.getLongitude()
                );
            }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, TestClass.class);
                startActivity(intent);
    }
}
