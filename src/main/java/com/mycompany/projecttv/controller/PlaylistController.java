
package com.mycompany.projecttv.controller;

import com.mycompany.projecttv.model.ListaReproducao;
import com.mycompany.projecttv.model.Video;
import java.util.ArrayList;
import java.util.List;

public class PlaylistController {
    private static List<ListaReproducao> minhasListas = new ArrayList<>();

    static {
        minhasListas.add(new ListaReproducao("Meus Favoritos"));
    }

    public List<ListaReproducao> getListas() {
        return minhasListas;
    }

    public void criarLista(String nome) {
        minhasListas.add(new ListaReproducao(nome));
    }

    public void favoritar(Video v) {
        if (!minhasListas.isEmpty()) {
            minhasListas.get(0).adicionarVideo(v);
        }
    }
    
}
