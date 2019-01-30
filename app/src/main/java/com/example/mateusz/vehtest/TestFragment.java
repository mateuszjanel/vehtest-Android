package com.example.mateusz.vehtest;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.anastr.speedviewlib.AwesomeSpeedometer;


public class TestFragment extends Fragment implements SensorEventListener {

    SensorManager sensorManager;
    Sensor accelerationSensor;

    TextView timerTextView;
    TextView timerTextViewTwenty;
    TextView timerTextViewFifty;
    TextView timerTextViewSeventy;
    TextView timerTextViewNinety;
    long startTime = 0;
    boolean timeMeasuringFlagTwenty = false;
    boolean timeMeasuringFlagFifty = false;
    boolean timeMeasuringFlagSeventy = false;
    boolean timeMeasuringFlagNinety = false;
    boolean timeMeasuringFlagHundred = false;
    boolean testFinished = false;

    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            timerTextView.setText(String.format("%d:%02d", seconds, millis % 1000));

            if(timeMeasuringFlagTwenty == true) {
                timerTextViewTwenty.setText(String.format("%d:%02d", seconds, millis % 1000));
            }

            if(timeMeasuringFlagFifty == true) {
                timerTextViewFifty.setText(String.format("%d:%02d", seconds, millis % 1000));
            }

            if(timeMeasuringFlagSeventy == true) {
                timerTextViewSeventy.setText(String.format("%d:%02d", seconds, millis % 1000));
            }

            if(timeMeasuringFlagNinety == true) {
                timerTextViewNinety.setText(String.format("%d:%02d", seconds, millis % 1000));
            }

            timerHandler.postDelayed(this, 500);
        }
    };

    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_fragment, container, false);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerationSensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        final LocationManager locationManager = (LocationManager) getActivity().getSystemService(getActivity().getApplicationContext().LOCATION_SERVICE);
        final String locationProvider = LocationManager.GPS_PROVIDER;

        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(getActivity(), getActivity().getString(R.string.gps_check_message), Toast.LENGTH_SHORT).show();
        }

        final AwesomeSpeedometer speedometer = getActivity().findViewById(R.id.awesomeSpeedometerTest);
        speedometer.speedTo(0);
        com.github.anastr.speedviewlib.AwesomeSpeedometer imageSpeedometer = getActivity().findViewById(R.id.imageSpeedometerTest);
        imageSpeedometer.speedPercentTo(50);

        //Sensor: accelerometer

        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        accelerationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        timerTextView = (TextView) getActivity().findViewById(R.id.timerTextView);
        timerTextViewTwenty = (TextView) getActivity().findViewById(R.id.timertwentyTextView);
        timerTextViewFifty = (TextView) getActivity().findViewById(R.id.timerfiftyTextView);
        timerTextViewSeventy = (TextView) getActivity().findViewById(R.id.timerseventyTextView);
        timerTextViewNinety = (TextView) getActivity().findViewById(R.id.timerninetyTextView);

        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
            } else {
                //Request the permission
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        1);

            }
        } else {

            final LocationListener locationListener = new LocationListener() {
                public void onLocationChanged(Location location) {
                    // Called when a new location is found by the network location provider.
                    speedometer.speedTo(location.getSpeed() * 3.6f);

                    if (location.getSpeed() > 0.0 && timeMeasuringFlagHundred == false && testFinished == false) {

                        //timerTextView.setText(String.valueOf(location.getSpeed()));
                        timeMeasuringFlagHundred = true;
                        timeMeasuringFlagTwenty = true;
                        timeMeasuringFlagFifty = true;
                        timeMeasuringFlagSeventy = true;
                        timeMeasuringFlagNinety = true;
                        startTime = System.currentTimeMillis();
                        timerHandler.postDelayed(timerRunnable, 0);
                    } else if (location.getSpeed() == 0.0 && timeMeasuringFlagHundred == true) {
                        timeMeasuringFlagHundred = false;
                        timeMeasuringFlagTwenty = false;
                        timeMeasuringFlagFifty = false;
                        timeMeasuringFlagSeventy = false;
                        timeMeasuringFlagNinety = false;
                        timerHandler.removeCallbacks(timerRunnable);
                    }

                    if (location.getSpeed() == 20) {

                        timeMeasuringFlagTwenty = false;

                    } else if (location.getSpeed() == 50) {
                        timeMeasuringFlagFifty = false;

                    } else if (location.getSpeed() == 70) {
                        timeMeasuringFlagSeventy = false;

                    } else if (location.getSpeed() == 90) {
                        timeMeasuringFlagNinety = false;

                    } else if (location.getSpeed() == 100) {
                        testFinished = true;
                        timerHandler.removeCallbacks(timerRunnable);
                        timeMeasuringFlagHundred = false;
                    }
                }

                public void onStatusChanged(String provider, int status, Bundle extras) {
                    /*if(status == LocationProvider.TEMPORARILY_UNAVAILABLE)
                    {
                        locationManager.removeUpdates(this);
                    }
                    else {
                        locationManager.requestLocationUpdates(locationProvider, 0, 0, this);
                    } //removing updates when gps signal is poor in order to prevent from false speed*/
                }

                public void onProviderEnabled(String provider) {
                }

                public void onProviderDisabled(String provider) {
                }
            };

            locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
        }


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        AwesomeSpeedometer imageSpeedometer = getActivity().findViewById(R.id.imageSpeedometerTest);
        imageSpeedometer.speedTo(50 + event.values[2] * 5, 100);
        Log.e("Accelerometer", Float.toString(event.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
