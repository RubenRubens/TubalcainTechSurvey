package com.example.survey.clases;

import java.util.ArrayList;

public class ClaseResultado {

    private String categoria;
    private ArrayList<ClaseTecnologia> tecnologias = new ArrayList<>();

    public ClaseResultado (String categoria){
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public ArrayList<ClaseTecnologia> getTecnologias() {
        return tecnologias;
    }

    public void addTecnologia(ClaseTecnologia claseTecnologia){
        this.tecnologias.add(claseTecnologia);
    }
}
