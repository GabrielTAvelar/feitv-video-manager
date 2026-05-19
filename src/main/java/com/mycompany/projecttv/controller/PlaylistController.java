package com.mycompany.projecttv.controller;

import com.mycompany.projecttv.dao.PlaylistDAO;
import com.mycompany.projecttv.view.PlaylistScreen;
import com.mycompany.projecttv.model.Sessao;
import java.util.List;
import java.util.ArrayList;

public class PlaylistController {
    private PlaylistScreen playlistscreen;
    
    public PlaylistController (PlaylistScreen playlistscreen){
        this.playlistscreen = playlistscreen;
    }
    
    private PlaylistDAO dao = new PlaylistDAO();
    
    public void criarLista(String nome) {
        if (Sessao.getUsuario() != null) {
            dao.salvarPlaylist(nome, Sessao.getUsuario().getId());
        }
    }

    public List<String> listarNomesMinhasPlaylists() {
        if (Sessao.getUsuario() != null) {
            return dao.listarPlaylists(Sessao.getUsuario().getId());
        }
        return new ArrayList<>();
    }

    public boolean excluirLista(String nome) {
        int idLogado = com.mycompany.projecttv.model.Sessao.getUsuario().getId();
        return dao.excluirPlaylist(nome, idLogado);
    }


    public boolean adicionarVideoPeloNome(String lista, String video) {
        if (Sessao.getUsuario() != null) {
            return dao.adicionarVideo(
                lista,
                video,
                Sessao.getUsuario().getId()
            );
        }
        return false;
    }

    public boolean removerVideoPeloNome(String lista, String video) {
        if (Sessao.getUsuario() != null) {
            return dao.removerVideo(
                lista,
                video,
                Sessao.getUsuario().getId()
            );
        }
        return false;
    }

    public List<String> getListas() {
        return listarNomesMinhasPlaylists();
    }
    
    public void criarPlaylist(){
            String nome = this.playlistscreen.getTxtNomeLista().getText();
            if (!nome.isEmpty()) {
            this.playlistscreen.getTxtNomeLista().setText("");
        }
    }
    public void apagarPlaylist(){
        String nome = this.playlistscreen.getTxtNomeLista().getText();
    if (nome.isEmpty()) {
        return;
    }

    if (this.excluirLista(nome)) {
        this.playlistscreen.getTxtAreaStatus().append(
            "Playlist '" + nome + "' removida com sucesso.\n"
        );
    } else {
        this.playlistscreen.getTxtAreaStatus().append(
            "Erro: Playlist '" + nome + "' não encontrada ou não pertence a você.\n"
        );
    }
    this.playlistscreen.getTxtNomeLista().setText("");
    }
    
    public void adicionarVideo(){
        String lista = this.playlistscreen.getTxtNomeLista().getText();
        String video = this.playlistscreen.getTxtNomeVideo().getText();
    
        if (this.adicionarVideoPeloNome(lista, video)) {
            this.playlistscreen.getTxtAreaStatus().append(video + "' adicionado em '" + lista + "'\n");
        } 
        else {
        this.playlistscreen.getTxtAreaStatus().append("Erro: Verifique se o vídeo e a lista existem.\n");
        }
        
    }
    public void removerVideo(){
        String lista = this.playlistscreen.getTxtNomeLista().getText();
        String video = this.playlistscreen.getTxtNomeVideo().getText();
        
            if (this.removerVideoPeloNome(lista, video)) {
                this.playlistscreen.getTxtAreaStatus().append(video + "' removido da lista '" + lista + "'\n");
            } 
            else {
            this.playlistscreen.getTxtAreaStatus().append("Erro: Vídeo não encontrado nesta lista.\n");
            }    
    }
    
    public void atualizarLista(){
        List<String> listas = this.listarNomesMinhasPlaylists();
        this.playlistscreen.getTxtAreaStatus().setText("--- Minhas Playlists no Banco ---\n");
        for (String nome : listas){
            this.playlistscreen.getTxtAreaStatus().append("- " + nome + "\n");
        }
    }
    
    public void mostrarPlaylist(){
        if (Sessao.getUsuario() == null) {
            this.playlistscreen.getTxtAreaStatus().setText("Erro: Nenhum usuário logado.\n");
            return;
        }

        int idUsuario = Sessao.getUsuario().getId();

        List<String> playlists = this.listarNomesMinhasPlaylists();

        this.playlistscreen.getTxtAreaStatus().setText("MINHAS PLAYLISTS E VÍDEOS\n\n");

        if (playlists.isEmpty()) {
            this.playlistscreen.getTxtAreaStatus().append("Você ainda não possui nenhuma playlist criada.\n");
            return;
        }

        for (String playlist : playlists) {
            this.playlistscreen.getTxtAreaStatus().append("Playlist: " + playlist.toUpperCase() + "\n");

            List<String> videos = this.dao.listarVideosDaPlaylist(playlist, idUsuario);

            if (videos.isEmpty()) {
                this.playlistscreen.getTxtAreaStatus().append("   (Nenhum vídeo nesta playlist)\n");
            } else {
                for (String video : videos) {
                    this.playlistscreen.getTxtAreaStatus().append("Vídeos:" + video + "\n");
                }
            }
            this.playlistscreen.getTxtAreaStatus().append("\n");
        }
    }
}

