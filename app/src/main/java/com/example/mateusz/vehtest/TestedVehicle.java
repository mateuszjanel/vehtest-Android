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
    private float vehicleToTwentyTime;

    @ColumnInfo(name = "toFifty")
    private float vehicleToFiftyTime;

    @ColumnInfo(name = "toSeventy")
    private float vehicleToSeventyTime;

    @ColumnInfo(name = "toNinety")
    private float vehicleToNinetyTime;

    @ColumnInfo(name = "toHundred")
    private float vehicleToHundredTime;

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

    public float getVehicleToTwentyTime() {
        return vehicleToTwentyTime;
    }

    public float getVehicleToFiftyTime() {
        return vehicleToFiftyTime;
    }

    public float getVehicleToSeventyTime() {
        return vehicleToSeventyTime;
    }

    public float getVehicleToNinetyTime() {
        return vehicleToNinetyTime;
    }

    public float getVehicleToHundredTime() {
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

    public void setVehicleToTwentyTime(float vehicleToTwentyTime) {
        this.vehicleToTwentyTime = vehicleToTwentyTime;
    }

    public void setVehicleToFiftyTime(float vehicleToFiftyTime) {
        this.vehicleToFiftyTime = vehicleToFiftyTime;
    }

    public void setVehicleToSeventyTime(float vehicleToSeventyTime) {
        this.vehicleToSeventyTime = vehicleToSeventyTime;
    }

    public void setVehicleToNinetyTime(float vehicleToNinetyTime) {
        this.vehicleToNinetyTime = vehicleToNinetyTime;
    }

    public void setVehicleToHundredTime(float vehicleToHundredTime) {
        this.vehicleToHundredTime = vehicleToHundredTime;
    }

    public void setVehicleAcceleration(float vehicleAcceleration) {
        this.vehicleAcceleration = vehicleAcceleration;
    }

    //test constructor

    public TestedVehicle(String testDate, String vehicleMark, String vehicleEngine, int vehiclePowerHP, String vehicleMadeDate, float vehicleToTwentyTime, float vehicleToFiftyTime, float vehicleToSeventyTime, float vehicleToNinetyTime, float vehicleToHundredTime, float vehicleAcceleration) {
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
