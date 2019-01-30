package com.example.mateusz.vehtest;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface VehicleDao {

    @Insert
    void insertAll(TestedVehicle... testedVehicles);

    @Insert
    long insert(TestedVehicle testedVehicle);

    @Query("UPDATE TestedVehicle SET testDate = :tDate, vehicleMark = :vehMark, vehicleEngine = :vehEngine, vehiclePowerHP = :vehPowerHP, vehicleMadeDate = :vehMadeDate, toTwenty = :twenty, toFifty = :fifty, toSeventy = :seventy, toNinety = :ninety, toHundred = :hundred, averageAcceleration = :avrAcceleration WHERE id = :ID")
    void updateTest(int ID, String tDate, String vehMark, String vehEngine, int vehPowerHP, String vehMadeDate, float twenty, float fifty, float seventy, float ninety, float hundred, float avrAcceleration);

    @Query("UPDATE TestedVehicle SET toTwenty = :twenty, toFifty = :fifty, toSeventy = :seventy, toNinety = :ninety, toHundred = :hundred WHERE id = :ID")
    void updateTestTimes(int ID, float twenty, float fifty, float seventy, float ninety, float hundred);

    @Query("UPDATE TestedVehicle SET testDate = :tDate, vehicleMark = :vehMark, vehicleEngine = :vehEngine, vehiclePowerHP = :vehPowerHP, vehicleMadeDate = :vehMadeDate WHERE id = :ID")
    void updateVehicleInfo(int ID, String tDate, String vehMark, String vehEngine, int vehPowerHP, String vehMadeDate);

    @Query("DELETE FROM TestedVehicle WHERE id = :ID")
    void removeTest(int ID);

    @Query("SELECT * FROM TestedVehicle")
    List<TestedVehicle> getTests();

    @Query("SELECT * FROM TestedVehicle WHERE id = :ID")
    TestedVehicle getTestById (long ID);

    @Query("SELECT * FROM TestedVehicle WHERE vehicleMark LIKE :vehMark")
    List<TestedVehicle> getTestsByVehicleMark(String vehMark);

    @Query("SELECT * FROM TestedVehicle WHERE testDate LIKE :tDate")
    List<TestedVehicle> getTestsByDate(String tDate);
}
