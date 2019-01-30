package com.example.mateusz.vehtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestListAdapter extends ArrayAdapter<TestedVehicle>{

    private int groupId;
    ArrayList<TestedVehicle> tests;
    Context context;
    LayoutInflater mInflater;

    public TestListAdapter(Context context, int vg, int id, ArrayList<TestedVehicle> tests) {
        super(context, vg, id, tests);

        groupId = vg;
        this.tests = tests;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final ViewHolder vh;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            View view = mInflater.inflate(groupId, parent, false);
            vh = ViewHolder.create((LinearLayout) view);
            view.setTag(vh);
        }
        else{
            vh = (ViewHolder) convertView.getTag();
        }
        // Lookup view for data population
        TestedVehicle vehicle = getItem(position);

        // Populate the data into the template view using the data object
        vh.date.setText(vehicle.getTestDate());
        vh.carMark.setText(vehicle.getVehicleMark());
        // Return the completed view to render on screen
        return vh.rootView;
    }

    private static class ViewHolder{
        public final LinearLayout rootView;
        public final ImageView imageView;
        public final TextView date;
        public final TextView carMark;

        private ViewHolder(LinearLayout rootView, ImageView imageView, TextView date, TextView carMark){
            this.rootView = rootView;
            this.imageView = imageView;
            this.date = date;
            this.carMark = carMark;
        }

        public static ViewHolder create(LinearLayout rootView){
            ImageView imageView = (ImageView) rootView.findViewById(R.id.plusImage);
            TextView date = (TextView) rootView.findViewById(R.id.testDateText);
            TextView carMark = (TextView) rootView.findViewById(R.id.testCarMark);

            return new ViewHolder(rootView, imageView, date, carMark);
        }
    }



}
