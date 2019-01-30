package com.example.mateusz.vehtest;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {TestedVehicle.class}, version = 1, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "TestedVehiclesDB";

    public abstract VehicleDao vehicleDao();
}
