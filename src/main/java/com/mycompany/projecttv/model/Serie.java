package com.mycompany.projecttv.model;

public class Serie extends Video {
    private int temporadas;

    public Serie(int id, String titulo, int temporadas) {
        super(id, titulo);
        this.temporadas = temporadas;
    }

    @Override
    public String getTipo() { return "Série"; }
    public int getTemporadas() {
        return temporadas; 
    }
}