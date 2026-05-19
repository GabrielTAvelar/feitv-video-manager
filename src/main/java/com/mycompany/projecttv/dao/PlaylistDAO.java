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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean excluirPlaylist(String nome, int usuarioId) {

        String sql = "DELETE FROM playlist WHERE nome = ? AND usuario_id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setInt(2, usuarioId);

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> listarPlaylists(int usuarioId) {

        List<String> lista = new ArrayList<>();

        String sql = "SELECT nome FROM playlist WHERE usuario_id = ?";

        try (Connection conn = new Conexao().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(rs.getString("nome"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

public boolean adicionarVideo(String nomePlaylist, String tituloVideo, int usuarioId) {

    String sqlBuscarPlaylist =
        "SELECT id FROM playlist " +
        "WHERE nome ILIKE ? AND usuario_id = ?";

    String sqlBuscarVideo =
        "SELECT id FROM video " +
        "WHERE titulo ILIKE ?";

    String sqlInserir =
        "INSERT INTO playlist_video (playlist_id, video_id) " +
        "VALUES (?, ?) " +
        "ON CONFLICT DO NOTHING";

    try (Connection conn = Conexao.getConexao()) {

        Integer idPlaylist = null;
        Integer idVideo = null;

        try (PreparedStatement stmt =
                 conn.prepareStatement(sqlBuscarPlaylist)) {

            stmt.setString(1, nomePlaylist.trim());
            stmt.setInt(2, usuarioId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idPlaylist = rs.getInt("id");
            }
        }

        try (PreparedStatement stmt =
                 conn.prepareStatement(sqlBuscarVideo)) {

            stmt.setString(1, tituloVideo.trim());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idVideo = rs.getInt("id");
            }
        }

        if (idPlaylist == null) {
            System.out.println("Playlist não encontrada");
            return false;
        }

        if (idVideo == null) {
            System.out.println("Vídeo não encontrado");
            return false;
        }

        try (PreparedStatement stmt =
                 conn.prepareStatement(sqlInserir)) {

            stmt.setInt(1, idPlaylist);
            stmt.setInt(2, idVideo);

            int linhas = stmt.executeUpdate();

            System.out.println("Linhas inseridas: " + linhas);

            return linhas > 0;
        }

    } catch (SQLException e) {

        e.printStackTrace();
        return false;
    }
}

    public boolean removerVideo(String nomePlaylist, String tituloVideo, int usuarioId) {

        String sql =
            "DELETE FROM playlist_video WHERE " + "playlist_id = (" + "SELECT id FROM playlist " +
            "WHERE nome ILIKE ? AND usuario_id = ?" +
            ") " + "AND video_id = (" + "SELECT id FROM video " + "WHERE titulo ILIKE ?" + ")";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nomePlaylist);
            stmt.setInt(2, usuarioId);
            stmt.setString(3, tituloVideo);

            int linhas = stmt.executeUpdate();

            return linhas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<String> listarVideosDaPlaylist(String nomePlaylist, int usuarioId) {
    List<String> videos = new ArrayList<>();
    
    String sql = "SELECT v.titulo FROM video v " + "JOIN playlist_video pv ON v.id = pv.video_id " +
                 "JOIN playlist p ON p.id = pv.playlist_id " + "WHERE p.nome ILIKE ? AND p.usuario_id = ?";

    try (Connection conn = Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nomePlaylist.trim());
        stmt.setInt(2, usuarioId);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                videos.add(rs.getString("titulo"));
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return videos;
    }
}