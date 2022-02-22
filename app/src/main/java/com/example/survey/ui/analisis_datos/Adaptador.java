package com.example.survey.ui.analisis_datos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.survey.R;
import com.example.survey.clases.ClaseResultado;
import com.example.survey.clases.ClaseTecnologia;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private Context context;
    private ArrayList<ClaseResultado> clasesResultados;

    public Adaptador(Context context, ArrayList<ClaseResultado> clasesResultados) {
        super();
        this.context = context;
        this.clasesResultados = clasesResultados;
    }

    @Override
    public int getCount() {
        return clasesResultados.size();
    }

    @Override
    public Object getItem(int position) {
        return clasesResultados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutResultado = LayoutInflater.from(context);
        View categoria = layoutResultado.inflate(R.layout.categoria, null, false);

        TextView txtCategoria = (TextView) categoria.findViewById(R.id.txtCategoria);
        txtCategoria.setText(clasesResultados.get(position).getCategoria());

        ListView listadoTecnologias = categoria.findViewById(R.id.listadoTecnologia);
        ArrayList<ClaseTecnologia> clasesTecnologias = clasesResultados.get(position).getTecnologias();
        Adaptador2 adaptador2 = new Adaptador2(context, clasesTecnologias);
        listadoTecnologias.setAdapter(adaptador2);

        return categoria;
    }
}
