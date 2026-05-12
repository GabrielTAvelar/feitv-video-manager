package com.mycompany.projecttv.controller;

import com.mycompany.projecttv.model.*;
import com.mycompany.projecttv.dao.VideoDAO;
import java.util.ArrayList;
import java.util.List;

public class VideoController {
    private VideoDAO videoDAO = new VideoDAO();

    public List<Video> buscar(String termo) {
        List<Video> resultados = new ArrayList<>();
        // Buscamos a lista atualizada do banco
        List<Video> catalogoDoBanco = videoDAO.listarTodos();
        
        for (Video v : catalogoDoBanco) {
            if (v.getTitulo().toLowerCase().contains(termo.toLowerCase())) {
                resultados.add(v);
            }
        }
        return resultados;
    }

    public Video buscarPorTitulo(String titulo) {
        for (Video v : videoDAO.listarTodos()) {
            if (v.getTitulo().trim().equalsIgnoreCase(titulo.trim())) {
               return v;
            }
        }
        return null;
    }
}