package com.example.survey.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Endpoints {
    @GET("/rest/?run=analisis_datos.xq/")
    Call<String> getData(@Header("Authorization") String auth);
}
