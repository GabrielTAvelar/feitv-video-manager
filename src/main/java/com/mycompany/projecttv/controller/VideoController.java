
package com.mycompany.projecttv.controller;

import com.mycompany.projecttv.model.*;
import java.util.ArrayList;
import java.util.List;

public class VideoController {
    private static List<Video> catalogo = new ArrayList<>();

    static {
        catalogo.add(new Filme("Inception", 148));
        catalogo.add(new Filme("Interestelar", 169));
        catalogo.add(new Serie("Breaking Bad", 5));
        catalogo.add(new Serie("Stranger Things", 4));
    }

    public List<Video> buscar(String termo) {
        List<Video> resultados = new ArrayList<>();
        for (Video v : catalogo) {
            if (v.getTitulo().toLowerCase().contains(termo.toLowerCase())) {
                resultados.add(v);
            }
        }
        return resultados;
    }
    
}
