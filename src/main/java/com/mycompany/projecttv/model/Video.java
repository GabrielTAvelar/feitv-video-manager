package com.mycompany.projecttv.model;

public abstract class Video implements Situacao {
    protected int id; // ADICIONE ISSO
    protected String titulo;

    public Video(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public int getId() { return id; } // ADICIONE O GETTER
    public String getTitulo() { return titulo; }
    
}