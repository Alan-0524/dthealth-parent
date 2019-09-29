package com.dthealth.mq.entities;

public class BodyIndex {

    private float bloodPressure; //60-100
    private float heartbeatStrength;
    private float bloodFat;
    private float bloodGlucose;
    private float temperature;

    public BodyIndex(String id, String userAccount, float bloodPressure, float heartbeatStrength, float bloodFat, float bloodGlucose, float temperature) {

        this.bloodPressure = bloodPressure;
        this.heartbeatStrength = heartbeatStrength;
        this.bloodFat = bloodFat;
        this.bloodGlucose = bloodGlucose;
        this.temperature = temperature;
    }

    public BodyIndex() {
    }

    public float getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(float bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public float getHeartbeatStrength() {
        return heartbeatStrength;
    }

    public void setHeartbeatStrength(float heartbeatStrength) {
        this.heartbeatStrength = heartbeatStrength;
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
