
package com.mycompany.projecttv.model;

public class Filme extends Video {
    private int duracao;
    
    public Filme(String titulo, int duracao){
        super(titulo);
        this.duracao = duracao;
    }
    
    @Override
    public String getTipo(){
        return "Filme";
    }
    public int getDuracao(){
        return duracao;
    }
}
