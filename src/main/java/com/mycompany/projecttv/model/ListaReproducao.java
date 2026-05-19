package com.mycompany.projecttv.model;

import java.util.ArrayList;
import java.util.List;

public class ListaReproducao {
    private String nome;
    private List<Video> videos;

    public ListaReproducao(String nome) {
        this.nome = nome;
        this.videos = new ArrayList<>();
    }

    public void adicionarVideo(Video v) {
        this.videos.add(v);
    }

    public void removerVideo(Video v) {
        this.videos.remove(v);
    }

    public String getNome() { return nome; }
    public List<Video> getVideos() { return videos; }
    
}
