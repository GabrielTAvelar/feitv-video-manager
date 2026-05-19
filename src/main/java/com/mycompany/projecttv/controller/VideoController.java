package com.mycompany.projecttv.controller;

import com.mycompany.projecttv.model.*;
import com.mycompany.projecttv.dao.VideoDAO;
import com.mycompany.projecttv.view.MainScreen;
import java.util.ArrayList;
import java.util.List;

public class VideoController {
    private MainScreen mainscreen;
    private VideoDAO videoDAO;
    
    public VideoController (MainScreen mainscreen){
        this.mainscreen = mainscreen;
        this.videoDAO = new VideoDAO();
    }

    public List<Video> buscar(String termo) {
        List<Video> resultados = new ArrayList<>();
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
    public void buscaDosVideos(){
        String termo = this.mainscreen.getTxtBusca().getText();
        
        java.util.List<com.mycompany.projecttv.model.Video> resultados = this.buscar(termo);
        
        this.mainscreen.getTxtAreaVideos().setText("");
        if (resultados.isEmpty()) {
            this.mainscreen.getTxtAreaVideos().setText("Nenhum vídeo encontrado");
        } else {
            for (com.mycompany.projecttv.model.Video v : resultados) {
                this.mainscreen.getTxtAreaVideos().append("Título: " + v.getTitulo() + "\n");            }
        }
    }
    
    public void Curtir(){
        String titulo = this.mainscreen.getTxtVideoSelecionado().getText();
    
        com.mycompany.projecttv.model.Video videoSelecionado = this.buscarPorTitulo(titulo);
    
        if (videoSelecionado != null) {
            int usuarioId = com.mycompany.projecttv.model.Sessao.getUsuario().getId();
            int videoId = videoSelecionado.getId();
        
            com.mycompany.projecttv.dao.VotoDAO vDao = new com.mycompany.projecttv.dao.VotoDAO();
        
            vDao.alternarLike(usuarioId, videoId);
        
            int totalLikes = vDao.contarLikes(videoId);
            javax.swing.JOptionPane.showMessageDialog(mainscreen, titulo + " agora possui " + totalLikes + " curtida(s)!");
        
        } 
        else {
            javax.swing.JOptionPane.showMessageDialog(mainscreen, "Vídeo não encontrado. Verifique o nome digitado.");
        }  
    }
}