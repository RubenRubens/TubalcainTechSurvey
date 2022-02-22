package com.example.survey.ui.analisis_datos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.survey.R;
import com.example.survey.clases.ClaseTecnologia;

import java.util.ArrayList;

public class AdaptadorTecnologia extends ArrayAdapter<ClaseTecnologia> {

    private ArrayList<ClaseTecnologia> tecnologias;

    public AdaptadorTecnologia(Context context, ArrayList<ClaseTecnologia> tecnologias) {
        super(context, R.layout.tecnologia, tecnologias);
        this.tecnologias = tecnologias;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutTecnologia = LayoutInflater.from(getContext());
        View tecnologia = layoutTecnologia.inflate(R.layout.tecnologia, null, false);

        TextView nombreTecnologia = (TextView) tecnologia.findViewById(R.id.nombre_tecnologia);
        nombreTecnologia.setText(tecnologias.get(position).getNombre());

        TextView porcentaje = (TextView) tecnologia.findViewById(R.id.porcentaje);
        porcentaje.setText(String.format("%.2f", tecnologias.get(position).getPorcentaje()) + " %");

        return tecnologia;
    }
}
