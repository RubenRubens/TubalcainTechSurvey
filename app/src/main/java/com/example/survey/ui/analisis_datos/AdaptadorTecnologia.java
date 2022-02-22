package com.example.survey.ui.analisis_datos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.survey.R;
import com.example.survey.clases.ClaseTecnologia;

import java.util.ArrayList;

public class AdaptadorTecnologia extends BaseAdapter {
    private Context context;
    private ArrayList<ClaseTecnologia> clasesTecnologias;

    public AdaptadorTecnologia(Context context, ArrayList<ClaseTecnologia> clasesTecnologia) {
        super();
        this.context = context;
        this.clasesTecnologias = clasesTecnologia;
    }

    @Override
    public int getCount() {
        return clasesTecnologias.size();
    }

    @Override
    public Object getItem(int position) {
        return clasesTecnologias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutTecnologia = LayoutInflater.from(context);
        View tecnologia = layoutTecnologia.inflate(R.layout.tecnologia, null, false);

        TextView txtTecnologia = (TextView) tecnologia.findViewById(R.id.txtTecnologia);
        txtTecnologia.setText(clasesTecnologias.get(position).getNombre());

        TextView txtPorcentaje = (TextView) tecnologia.findViewById(R.id.txtPorcentaje);
        txtPorcentaje.setText(String.valueOf(clasesTecnologias.get(position).getPorcentaje()));

        return tecnologia;
    }
}
