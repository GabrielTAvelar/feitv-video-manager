package com.mycompany.projecttv.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {
    public void salvarPlaylist(String nome, int usuarioId) {
        String sql = "INSERT INTO playlist (nome, usuario_id) VALUES (?, ?)";
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, usuarioId);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    public void excluirPlaylist(String nome) {
    String sql = "DELETE FROM playlist WHERE nome = ?";
    try (Connection conn = Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nome);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public List<String> listarPlaylists(int usuarioId) {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT nome FROM playlist WHERE usuario_id = ?";
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) { lista.add(rs.getString("nome")); }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }
}