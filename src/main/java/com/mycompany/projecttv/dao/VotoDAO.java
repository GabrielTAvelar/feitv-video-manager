package com.mycompany.projecttv.dao;

import java.sql.*;

public class VotoDAO {

    // Agora aceita 1 para Like e -1 para Dislike
    public void registrarVoto(int usuarioId, int videoId, int valor) {
        String sql = "INSERT INTO likes_votos (usuario_id, video_id, voto) VALUES (?, ?, ?) " +
                     "ON CONFLICT (usuario_id, video_id) DO UPDATE SET voto = EXCLUDED.voto";
        
        try (Connection conn = Conexao.getConexao(); // Usando nosso método estático
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, videoId);
            stmt.setInt(3, valor);
            stmt.executeUpdate();
            
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
    }

    // Soma todos os votos (1 e -1). O resultado é o saldo real.
    public int obterSaldoVotos(int videoId) {
        String sql = "SELECT SUM(voto) FROM likes_votos WHERE video_id = ?";
        
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, videoId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1); // Retorna a soma (ex: 5 likes - 3 dislikes = 2)
            }
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        return 0;
    }
}