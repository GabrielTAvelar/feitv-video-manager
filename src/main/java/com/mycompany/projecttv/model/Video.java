package com.mycompany.projecttv.model;

public abstract class Video implements Situacao {
    protected String titulo;
    protected int curtidas;

    public Video(String titulo) {
        this.titulo = titulo;
        this.curtidas = 0;
    }

    public void curtir() {
        this.curtidas++;
    }

    public void descurtir() {
        if (this.curtidas > 0) {
            this.curtidas--;
        }
    }

    public String getTitulo() { 
        return titulo;
    }
    public int getCurtidas() {
        return curtidas; 
    }
}