package com.example.mateusz.vehtest;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TestDetailsFragment extends Fragment {

    Long idFromDB;
    AppDatabase appDatabase;
    TestedVehicle testedVehicle;

    TextView idInView;
    TextView testDate;
    TextView vehicleMark;
    TextView engine;
    TextView power;
    TextView prodDate;
    TextView twenty;
    TextView fifty;
    TextView seventy;
    TextView ninety;
    TextView hundred;
    TextView accel;

    public TestDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.idFromDB = getArguments().getLong("idFromDB");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_details, container, false);


    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        Context appContext = getActivity().getApplicationContext();

        appDatabase = Room.databaseBuilder(appContext, AppDatabase.class, AppDatabase.DATABASE_NAME).allowMainThreadQueries().build();
        testedVehicle = appDatabase.vehicleDao().getTestById(idFromDB);

        idInView = getActivity().findViewById(R.id.idText);
        testDate = getActivity().findViewById(R.id.testDateText);
        vehicleMark = getActivity().findViewById(R.id.carMarkText);
       engine = getActivity().findViewById(R.id.engineText);
        power = getActivity().findViewById(R.id.powerText);
        prodDate = getActivity().findViewById(R.id.madeDateText);
        twenty = getActivity().findViewById(R.id.twentyText);
        fifty = getActivity().findViewById(R.id.fiftyText);
        seventy = getActivity().findViewById(R.id.seventyText);
        ninety = getActivity().findViewById(R.id.ninetyName);
        hundred = getActivity().findViewById(R.id.hundredText);
        accel = getActivity().findViewById(R.id.accelerationText);

    }
}
