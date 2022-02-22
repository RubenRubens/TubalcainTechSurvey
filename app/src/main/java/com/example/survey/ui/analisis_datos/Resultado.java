package com.example.survey.ui.analisis_datos;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.survey.R;
import com.example.survey.api.Datos;
import com.example.survey.api.RetrofitUtil;
import com.example.survey.clases.ClaseResultado;
import com.example.survey.factories.ResultadoFactory;

import java.util.ArrayList;

import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Estraido de:
// https://stackoverflow.com/questions/62901224/read-plain-text-response-from-server-using-retrofit

public class Resultado extends AppCompatActivity {

    String textoXml;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //textView = (TextView) findViewById(R.id.textView);
        Context contexto = Resultado.this;
        obtenerResultadosXML("demo", contexto);
    }

    private void obtenerResultadosXML(String codigo, Context contexto) {
        Datos resultadoEncuesta = RetrofitUtil.retrofit.create(Datos.class);
        Call<String> call = resultadoEncuesta.getData(Credentials.basic(codigo, codigo));
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Retrofit", "Codigo HTTP " + response.code());
                textoXml = response.body();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        // Trabajar aqui dentro -------------------------
                        try {
                            ResultadoFactory resultadoFactory = new ResultadoFactory(textoXml);
                            ArrayList<ClaseResultado> resultadoEncuesta = resultadoFactory.obtenerResultado();
                            ListView listado = findViewById(R.id.listado);
                            Adaptador adaptador = new Adaptador(contexto, resultadoEncuesta);
                            listado.setAdapter(adaptador);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        // ----------------------------------------------


                    }
                });
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("Retrofit", t.getMessage());
            }
        });
    }

}
