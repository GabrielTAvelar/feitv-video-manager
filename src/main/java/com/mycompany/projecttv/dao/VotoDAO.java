package com.mycompany.projecttv.dao;

import java.sql.*;

public class VotoDAO {

    public void alternarLike(int usuarioId, int videoId) {
        String sqlVerificar = "SELECT 1 FROM likes_votos WHERE usuario_id = ? AND video_id = ?";
        String sqlInserir = "INSERT INTO likes_votos (usuario_id, video_id) VALUES (?, ?)";
        String sqlDeletar = "DELETE FROM likes_votos WHERE usuario_id = ? AND video_id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmtVerificar = conn.prepareStatement(sqlVerificar)) {


            stmtVerificar.setInt(1, usuarioId);
            stmtVerificar.setInt(2, videoId);
            ResultSet rs = stmtVerificar.executeQuery();

            if (rs.next()) {
                try (PreparedStatement stmtDeletar = conn.prepareStatement(sqlDeletar)) {
                    stmtDeletar.setInt(1, usuarioId);
                    stmtDeletar.setInt(2, videoId);
                    stmtDeletar.executeUpdate();
                }
            } else {
                try (PreparedStatement stmtInserir = conn.prepareStatement(sqlInserir)) {
                    stmtInserir.setInt(1, usuarioId);
                    stmtInserir.setInt(2, videoId);
                    stmtInserir.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int contarLikes(int videoId) {
        String sql = "SELECT COUNT(*) FROM likes_votos WHERE video_id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, videoId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}