
package com.mycompany.projecttv.model;


public abstract class Video implements Situacao {
    protected String titulo;
    protected int curtidas;
    
    public Video(String titulo){
        this.titulo = titulo;
        this.curtidas = 0;
    }

    public String getTitle() {
        return titulo;
    }

    public void setTitle(String title) {
        this.titulo = title;
    }

    public int getLike() {
        return curtidas;
    }

    public void setLike(int like) {
        this.curtidas = like;
    }
    
    public void likes(){
        this.curtidas++;
    }
    public void dislike(){
        if(this.curtidas > 0)
            this.curtidas--;
    }
}
