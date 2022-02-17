package com.example.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.survey.api.Datos;
import com.example.survey.api.RetrofitUtil;

import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Estraido de:
// https://stackoverflow.com/questions/62901224/read-plain-text-response-from-server-using-retrofit

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView textView = (TextView) findViewById(R.id.textView);

        Datos resultadoEncuesta = RetrofitUtil.retrofit.create(Datos.class);
        Call<String> call = resultadoEncuesta.getData(Credentials.basic("demo", "demo"));
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String plain_text_response = response.body();
                textView.setText(plain_text_response);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

}
