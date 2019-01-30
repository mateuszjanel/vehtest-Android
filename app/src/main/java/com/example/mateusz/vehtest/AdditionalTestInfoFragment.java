package com.example.mateusz.vehtest;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class AdditionalTestInfoFragment extends Fragment {

    Long idFromDB;
    AppDatabase appDatabase;

    TextView vehicleMark;
    TextView engine;
    TextView power;
    TextView prodDate;

    public AdditionalTestInfoFragment() {
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
        return inflater.inflate(R.layout.fragment_additional_test_info, container, false);
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

        vehicleMark = getActivity().findViewById(R.id.carMarkInput);
        engine = getActivity().findViewById(R.id.engineInput);
        power = getActivity().findViewById(R.id.powerInput);
        prodDate = getActivity().findViewById(R.id.madeDateInput);

        Context appContext = getActivity().getApplicationContext();

        appDatabase = Room.databaseBuilder(appContext, AppDatabase.class, AppDatabase.DATABASE_NAME).allowMainThreadQueries().build();

        FloatingActionButton floatingActionButton = getActivity().findViewById(R.id.saveToDbButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    appDatabase.vehicleDao().updateVehicleInfo(idFromDB, vehicleMark.getText().toString(), engine.getText().toString(), Integer.parseInt(power.getText().toString()), prodDate.getText().toString());
                    Fragment fragment = new TestsListFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.view_content, Objects.requireNonNull(fragment));
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
        });
    }

}
