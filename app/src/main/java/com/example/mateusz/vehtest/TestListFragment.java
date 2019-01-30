package com.example.mateusz.vehtest;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class TestListFragment extends Fragment {


    ArrayList<TestedVehicle> arrayOfTestedVehicles = new ArrayList<TestedVehicle>();
    TestListAdapter adapter = new TestListAdapter(getActivity(), R.layout.list_item, R.id.plusImage, arrayOfTestedVehicles);


    AppDatabase appDatabase;

    public TestListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_list, container, false);


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

        ListView listView = (ListView) getActivity().findViewById(R.id.testListView);


        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");//formating according to my need
        TestedVehicle exampleTest = new TestedVehicle(formatter.format(Calendar.getInstance().getTime()), "Citroen C4", "1.6 HDI", 120, formatter.format(Calendar.getInstance().getTime()), 03.12f, 05.13f, 21.23f, 30.21f, 35.20f, 12.25f );
        Context appContext = getActivity().getApplicationContext();
        appDatabase = Room.databaseBuilder(appContext, AppDatabase.class, AppDatabase.DATABASE_NAME).allowMainThreadQueries().build();
        appDatabase.vehicleDao().insert(exampleTest);
        listView.setAdapter(adapter);




        arrayOfTestedVehicles = (ArrayList<TestedVehicle>) appDatabase.vehicleDao().getTests();
    }
}
