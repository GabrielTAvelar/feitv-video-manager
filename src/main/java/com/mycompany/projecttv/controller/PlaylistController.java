package com.mycompany.projecttv.controller;

import com.mycompany.projecttv.dao.PlaylistDAO;
import com.mycompany.projecttv.model.Sessao;
import java.util.List;
import java.util.ArrayList;

public class PlaylistController {
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

    // Métodos para satisfazer a PlaylistScreen
    public void excluirLista(String nome) {
        dao.excluirPlaylist(nome);
    }

    public boolean adicionarVideoPeloNome(String lista, String video) {
        return true; 
    }

    public boolean removerVideoPeloNome(String lista, String video) {
        return true;
    }

    public List<String> getListas() {
        return listarNomesMinhasPlaylists();
    }
}