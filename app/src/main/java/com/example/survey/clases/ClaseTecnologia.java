package com.example.survey.clases;

public class ClaseTecnologia {

    private String nombre;
    private int respuestas;
    private double porcentaje;

    public ClaseTecnologia(String nombre, int respuestas, double porcentaje) {
        this.nombre = nombre;
        this.respuestas = respuestas;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRespuestas() {
        return respuestas;
    }

    public String getPorcentaje() {
        return porcentaje * 100 + " %";
    }
}
