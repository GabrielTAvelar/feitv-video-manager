package com.mycompany.projecttv.dao;

import com.mycompany.projecttv.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean cadastrar(String nome, String login, String senha) {
        String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)";
        
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nome);
            stmt.setString(2, login);
            stmt.setString(3, senha);
            
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
            return false;
        }
    }

    public boolean autenticar(String login, String senha) {
        String sql = "SELECT id FROM usuario WHERE login = ? AND senha = ?";
        
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao autenticar: " + e.getMessage());
            return false;
        }
    }

    public Usuario buscarPorLogin(String login) {
        String sql = "SELECT id, nome, login FROM usuario WHERE login = ?";
        
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, login);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setNome(rs.getString("nome"));
                    u.setLogin(rs.getString("login"));
                    return u;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar dados do usuário: " + e.getMessage());
        }
        return null;
    }
}