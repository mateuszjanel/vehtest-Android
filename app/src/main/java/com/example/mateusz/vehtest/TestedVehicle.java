package com.example.mateusz.vehtest;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity
public class TestedVehicle {

    @PrimaryKey (autoGenerate = true)
    public int id;

    @ColumnInfo(name = "testDate")
    private String testDate;

    @ColumnInfo(name = "vehicleMark")
    private String vehicleMark;

    @ColumnInfo(name = "vehicleEngine")
    private String vehicleEngine;

    @ColumnInfo(name = "vehiclePowerHP")
    private int vehiclePowerHP;

    @ColumnInfo(name = "vehicleMadeDate")
    private String vehicleMadeDate;

    @ColumnInfo(name = "toTwenty")
    private String vehicleToTwentyTime;

    @ColumnInfo(name = "toFifty")
    private String vehicleToFiftyTime;

    @ColumnInfo(name = "toSeventy")
    private String vehicleToSeventyTime;

    @ColumnInfo(name = "toNinety")
    private String vehicleToNinetyTime;

    @ColumnInfo(name = "toHundred")
    private String vehicleToHundredTime;

    @ColumnInfo(name = "averageAcceleration")
    private float vehicleAcceleration;

    //getters
    public int getId() {
        return id;
    }

    public String getTestDate() {
        return testDate;
    }

    public String getVehicleMark() {
        return vehicleMark;
    }

    public String getVehicleEngine() {
        return vehicleEngine;
    }

    public int getVehiclePowerHP() {
        return vehiclePowerHP;
    }

    public String getVehicleMadeDate() {
        return vehicleMadeDate;
    }

    public String getVehicleToTwentyTime() {
        return vehicleToTwentyTime;
    }

    public String getVehicleToFiftyTime() {
        return vehicleToFiftyTime;
    }

    public String getVehicleToSeventyTime() {
        return vehicleToSeventyTime;
    }

    public String getVehicleToNinetyTime() {
        return vehicleToNinetyTime;
    }

    public String getVehicleToHundredTime() {
        return vehicleToHundredTime;
    }

    public float getVehicleAcceleration() {
        return vehicleAcceleration;
    }

    //setters
    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public void setVehicleMark(String vehicleMark) {
        this.vehicleMark = vehicleMark;
    }

    public void setVehicleEngine(String vehicleEngine) {
        this.vehicleEngine = vehicleEngine;
    }

    public void setVehiclePowerHP(int vehiclePowerHP) {
        this.vehiclePowerHP = vehiclePowerHP;
    }

    public void setVehicleMadeDate(String vehicleMadeDate) {
        this.vehicleMadeDate = vehicleMadeDate;
    }

    public void setVehicleToTwentyTime(String vehicleToTwentyTime) {
        this.vehicleToTwentyTime = vehicleToTwentyTime;
    }

    public void setVehicleToFiftyTime(String vehicleToFiftyTime) {
        this.vehicleToFiftyTime = vehicleToFiftyTime;
    }

    public void setVehicleToSeventyTime(String vehicleToSeventyTime) {
        this.vehicleToSeventyTime = vehicleToSeventyTime;
    }

    public void setVehicleToNinetyTime(String vehicleToNinetyTime) {
        this.vehicleToNinetyTime = vehicleToNinetyTime;
    }

    public void setVehicleToHundredTime(String vehicleToHundredTime) {
        this.vehicleToHundredTime = vehicleToHundredTime;
    }

    public void setVehicleAcceleration(float vehicleAcceleration) {
        this.vehicleAcceleration = vehicleAcceleration;
    }

    //test constructor


    public TestedVehicle(String testDate, String vehicleMark, String vehicleEngine, int vehiclePowerHP, String vehicleMadeDate, String vehicleToTwentyTime, String vehicleToFiftyTime, String vehicleToSeventyTime, String vehicleToNinetyTime, String vehicleToHundredTime, float vehicleAcceleration) {
        this.testDate = testDate;
        this.vehicleMark = vehicleMark;
        this.vehicleEngine = vehicleEngine;
        this.vehiclePowerHP = vehiclePowerHP;
        this.vehicleMadeDate = vehicleMadeDate;
        this.vehicleToTwentyTime = vehicleToTwentyTime;
        this.vehicleToFiftyTime = vehicleToFiftyTime;
        this.vehicleToSeventyTime = vehicleToSeventyTime;
        this.vehicleToNinetyTime = vehicleToNinetyTime;
        this.vehicleToHundredTime = vehicleToHundredTime;
        this.vehicleAcceleration = vehicleAcceleration;
    }
}
