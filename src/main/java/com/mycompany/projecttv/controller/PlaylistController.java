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
}