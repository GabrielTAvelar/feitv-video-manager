package com.mycompany.projecttv.controller;

import com.mycompany.projecttv.dao.UsuarioDAO;
import com.mycompany.projecttv.model.Usuario;

public class ControledoUsuario {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public boolean cadastrar(String nome, String login, String senha) {
        if (nome.isEmpty() || login.isEmpty() || senha.isEmpty()) return false;
        return usuarioDAO.cadastrar(nome, login, senha);
    }

    public boolean autenticar(String login, String senha) {
        return usuarioDAO.autenticar(login, senha);
    }

    public Usuario buscarUsuarioPeloLogin(String login) {
        return usuarioDAO.buscarPorLogin(login);
    }
}