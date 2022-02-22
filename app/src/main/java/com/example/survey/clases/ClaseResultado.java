package com.example.survey.clases;

import java.util.ArrayList;

public class ClaseResultado {

    private String categoria;
    private ArrayList<ClaseTecnologia> tecnologias = new ArrayList<>();

    public ClaseResultado (String categoria){
        this.categoria = categoria;
    }

    public String getCategoria() {
        return mayusculasOracion(categoria.replace("_", " "));
    }

    public ArrayList<ClaseTecnologia> getTecnologias() {
        return tecnologias;
    }

    public void addTecnologia(ClaseTecnologia claseTecnologia){
        this.tecnologias.add(claseTecnologia);
    }

    // Convierte las mayusculas a tipo oración
    private String mayusculasOracion(String texto) {
        String nuevoTexto = "";
        for (String palabra : texto.split(" ")) {
            nuevoTexto += palabra.substring(0, 1).toUpperCase()
                    + palabra.substring(1).toLowerCase() + " ";
        }
        return nuevoTexto;
    }
}
