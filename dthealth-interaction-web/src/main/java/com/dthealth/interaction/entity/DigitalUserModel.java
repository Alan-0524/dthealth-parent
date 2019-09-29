package com.dthealth.interaction.entity;

import org.springframework.data.annotation.Id;

public class DigitalUserModel {
    @Id
    private String id;
    private String userId;

    private float minBloodPressure;
    private float maxBloodPressure;

    private float minHeartbeatStrength;
    private float maxHeartbeatStrength;

    private float minHeartbeat;
    private float maxHeartbeat;

    private float minBloodFat;
    private float maxBloodFat;

    private float minBloodGlucose;
    private float maxBloodGlucose;

    private float minTemperature;
    private float maxTemperature;

    public DigitalUserModel(String id, String userId, float minBloodPressure, float maxBloodPressure, float minHeartbeatStrength, float maxHeartbeatStrength, float minHeartbeat, float maxHeartbeat, float minBloodFat, float maxBloodFat, float minBloodGlucose, float maxBloodGlucose, float minTemperature, float maxTemperature) {
        this.id = id;
        this.userId = userId;
        this.minBloodPressure = minBloodPressure;
        this.maxBloodPressure = maxBloodPressure;
        this.minHeartbeatStrength = minHeartbeatStrength;
        this.maxHeartbeatStrength = maxHeartbeatStrength;
        this.minHeartbeat = minHeartbeat;
        this.maxHeartbeat = maxHeartbeat;
        this.minBloodFat = minBloodFat;
        this.maxBloodFat = maxBloodFat;
        this.minBloodGlucose = minBloodGlucose;
        this.maxBloodGlucose = maxBloodGlucose;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public float getMinBloodPressure() {
        return minBloodPressure;
    }

    public void setMinBloodPressure(float minBloodPressure) {
        this.minBloodPressure = minBloodPressure;
    }

    public float getMaxBloodPressure() {
        return maxBloodPressure;
    }

    public void setMaxBloodPressure(float maxBloodPressure) {
        this.maxBloodPressure = maxBloodPressure;
    }

    public float getMinHeartbeatStrength() {
        return minHeartbeatStrength;
    }

    public void setMinHeartbeatStrength(float minHeartbeatStrength) {
        this.minHeartbeatStrength = minHeartbeatStrength;
    }

    public float getMaxHeartbeatStrength() {
        return maxHeartbeatStrength;
    }

    public void setMaxHeartbeatStrength(float maxHeartbeatStrength) {
        this.maxHeartbeatStrength = maxHeartbeatStrength;
    }

    public float getMinHeartbeat() {
        return minHeartbeat;
    }

    public void setMinHeartbeat(float minHeartbeat) {
        this.minHeartbeat = minHeartbeat;
    }

    public float getMaxHeartbeat() {
        return maxHeartbeat;
    }

    public void setMaxHeartbeat(float maxHeartbeat) {
        this.maxHeartbeat = maxHeartbeat;
    }

    public float getMinBloodFat() {
        return minBloodFat;
    }

    public void setMinBloodFat(float minBloodFat) {
        this.minBloodFat = minBloodFat;
    }

    public float getMaxBloodFat() {
        return maxBloodFat;
    }

    public void setMaxBloodFat(float maxBloodFat) {
        this.maxBloodFat = maxBloodFat;
    }

    public float getMinBloodGlucose() {
        return minBloodGlucose;
    }

    public void setMinBloodGlucose(float minBloodGlucose) {
        this.minBloodGlucose = minBloodGlucose;
    }

    public float getMaxBloodGlucose() {
        return maxBloodGlucose;
    }

    public void setMaxBloodGlucose(float maxBloodGlucose) {
        this.maxBloodGlucose = maxBloodGlucose;
    }

    public float getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(float minTemperature) {
        this.minTemperature = minTemperature;
    }

    public float getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(float maxTemperature) {
        this.maxTemperature = maxTemperature;
    }
}
