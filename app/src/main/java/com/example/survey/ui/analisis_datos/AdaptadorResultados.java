package com.example.survey.ui.analisis_datos;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.survey.R;
import com.example.survey.clases.ClaseResultado;
import com.example.survey.clases.ClaseTecnologia;

import java.util.ArrayList;

public class AdaptadorResultados extends ArrayAdapter<ClaseResultado> {

    private ArrayList<ClaseResultado> resultados;

    public AdaptadorResultados(Context context, ArrayList<ClaseResultado> resultados) {
        super(context, R.layout.categoria, resultados);
        this.resultados = resultados;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutResultado = LayoutInflater.from(getContext());
        View categoria = layoutResultado.inflate(R.layout.categoria, null, false);

        TextView nombreCategoria = (TextView) categoria.findViewById(R.id.nombre_categoria);
        nombreCategoria.setText(resultados.get(position).getCategoria());

        ListView listaTecnologias = categoria.findViewById(R.id.lista_tecnologias);
        ArrayList<ClaseTecnologia> tecnologias = resultados.get(position).getTecnologias();
        Log.i("adaptador", String.valueOf(tecnologias.size()));
        AdaptadorTecnologia adaptadorTecnologia = new AdaptadorTecnologia(getContext(), tecnologias);
        listaTecnologias.setAdapter(adaptadorTecnologia);

        return categoria;
    }
}
