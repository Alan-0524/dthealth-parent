package com.dthealth.dao.entity;

import org.springframework.data.annotation.Id;

public class BodyIndex {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String userAccount;
    private float bloodPressure; //60-100
    private float heartRate;
    private float bloodFat;
    private float bloodGlucose;
    private float temperature;

    public BodyIndex(String id, String userAccount, float bloodPressure, float heartRate, float bloodFat, float bloodGlucose, float temperature) {
        this.id = id;
        this.userAccount = userAccount;
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
        this.bloodFat = bloodFat;
        this.bloodGlucose = bloodGlucose;
        this.temperature = temperature;
    }
    public BodyIndex(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public float getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(float bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public float getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(float heartRate) {
        this.heartRate = heartRate;
    }

    public float getBloodFat() {
        return bloodFat;
    }

    public void setBloodFat(float bloodFat) {
        this.bloodFat = bloodFat;
    }

    public float getBloodGlucose() {
        return bloodGlucose;
    }

    public void setBloodGlucose(float bloodGlucose) {
        this.bloodGlucose = bloodGlucose;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
