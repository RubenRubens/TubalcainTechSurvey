package com.example.survey;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class InicioFragmento extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inicio_fragmento, container, false);

        MaterialButton botonComenzar = view.findViewById(R.id.comenzar);
        botonComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), RealizarEncuestaLenguajes.class));
            }
        });

        MaterialButton botonResultados = view.findViewById(R.id.resultados);
        botonResultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Resultado.class));
            }
        });

        return view;
    }
}
