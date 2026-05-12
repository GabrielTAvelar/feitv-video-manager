package com.mycompany.projecttv.model;

public class Filme extends Video {
    private int duracao;
    private String genero;

    public Filme(int id, String titulo, String genero, int duracao) {
        super(id, titulo);
        this.genero = genero;
        this.duracao = duracao;
    }

    @Override
    public String getTipo() { return "Filme"; }
    public int getDuracao() { return duracao; }
    public String getGenero() { return genero; }
}