package com.example.mateusz.vehtest;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;


public class TestsListFragment extends Fragment {

    ArrayList<TestedVehicle> arrayOfTestedVehicles = new ArrayList<TestedVehicle>();
    TestListAdapter adapter;


    AppDatabase appDatabase;

    public TestsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tests_list, container, false);
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


        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");//formating according to my need
        Context appContext = getActivity().getApplicationContext();

        appDatabase = Room.databaseBuilder(appContext, AppDatabase.class, AppDatabase.DATABASE_NAME).allowMainThreadQueries().build();
        //appDatabase.vehicleDao().insert(exampleTest);
        arrayOfTestedVehicles = (ArrayList<TestedVehicle>) appDatabase.vehicleDao().getTests();
        ListView listView = (ListView) getActivity().findViewById(R.id.testListView);
        adapter = new TestListAdapter(getActivity(), R.layout.list_item, R.id.plusImage, arrayOfTestedVehicles);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.v("ListFragment", "Klik");
                Fragment fragment = new TestDetailsFragment();
                long dbId = arrayOfTestedVehicles.get(position).getId();
                Bundle bundle = new Bundle();
                bundle.putLong("idFromDB", dbId);
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.view_content, Objects.requireNonNull(fragment));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });


    }

}
