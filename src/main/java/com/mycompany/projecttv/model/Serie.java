
package com.mycompany.projecttv.model;

public class Serie extends Video{
    private int temporadas;
    
    public Serie(String titulo, int temporadas){
        super(titulo);
        this.temporadas = temporadas;
    }
    
    @Override
    public String GetTipo(){
        return "Série";
    }
    public int getTemporadas(){
        return temporadas;
    }
}
