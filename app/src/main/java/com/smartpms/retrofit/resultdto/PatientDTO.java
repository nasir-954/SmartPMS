package com.smartpms.retrofit.resultdto;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class PatientDTO {
    @SerializedName("patientid")
    private int patientid;
    @SerializedName("temparature")
    private float temparature;
    @SerializedName("bpm")
    private float bpm;
    @SerializedName("spo2")
    private float spo2;
    @SerializedName("insertdate")
    private String insertdate;

    public int getPatientid() {
        return patientid;
    }
    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }
    public float getTemparature() {
        return temparature;
    }
    public void setTemparature(float temparature) {
        this.temparature = temparature;
    }
    public float getBpm() {
        return bpm;
    }
    public void setBpm(float bpm) {
        this.bpm = bpm;
    }
    public float getSpo2() {
        return spo2;
    }
    public void setSpo2(float spo2) {
        this.spo2 = spo2;
    }
    public String getInsertdate() {
        return insertdate;
    }
    public void setInsertdate(String insertdate) {
        this.insertdate = insertdate;
    }

    @Override
    public String toString(){
        return new com.google.gson.Gson().toJson(this);
    }
}
