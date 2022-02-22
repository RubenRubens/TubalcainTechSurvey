package com.example.survey.ui.realizar_encuesta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.survey.R;
import com.google.android.material.button.MaterialButton;

public class RealizarEncuestaIDE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.realizar_encuesta_ide_activity);

        MaterialButton siguiente = (MaterialButton) findViewById(R.id.siguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RealizarEncuestaWeb.class));
            }
        });

        MaterialButton anterior = (MaterialButton) findViewById(R.id.anterior);
        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RealizarEncuestaWeb.class));
            }
        });

    }
}