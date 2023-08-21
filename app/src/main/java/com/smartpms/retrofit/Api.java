package com.smartpms.retrofit;

import com.smartpms.retrofit.resultdto.PatientDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "http://10.15.5.66:8080/";
    @GET("sphms")
    Call<Integer> getUserid();

    @GET("getPatientInfo")
    Call<PatientDTO> getPatient();
}