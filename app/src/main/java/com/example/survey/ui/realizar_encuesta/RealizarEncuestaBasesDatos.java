package com.example.survey.ui.realizar_encuesta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.survey.R;
import com.google.android.material.button.MaterialButton;

public class RealizarEncuestaBasesDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.realizar_encuesta_bd_activity);


        MaterialButton siguiente = (MaterialButton) findViewById(R.id.siguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RealizarEncuestaIDE.class));
            }
        });

        MaterialButton anterior = (MaterialButton) findViewById(R.id.anterior);
        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RealizarEncuestaLenguajes.class));
            }
        });

    }
}