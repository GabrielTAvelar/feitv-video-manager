
package com.mycompany.projecttv.controller;

import com.mycompany.projecttv.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class ControledoUsuario {
    private static List<Usuario> usuariosFakeDB = new ArrayList<>();
    
    public boolean cadastrar(String nome, String login, String senha){
        if (login.isEmpty() || senha.isEmpty()) return false;
        
        for (Usuario u : usuariosFakeDB){
            if (u.getLogin().equals(login)) return false;
        }
        
        usuariosFakeDB.add(new Usuario(nome, login, senha));
        return true;    
    }
    
    public boolean autenticar(String login, String senha){
        for(Usuario u : usuariosFakeDB) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
    
}
