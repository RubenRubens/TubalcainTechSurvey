package com.example.survey.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitUtil {

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Config.WEB_SERVER)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();

}
