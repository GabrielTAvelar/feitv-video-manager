package com.mycompany.projecttv.dao;

import com.mycompany.projecttv.model.Filme;
import com.mycompany.projecttv.model.Serie;
import com.mycompany.projecttv.model.Video;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO {
    public List<Video> listarTodos() {
        List<Video> lista = new ArrayList<>();
        String sql = "SELECT * FROM video";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String tipo = rs.getString("tipo");

                if ("Filme".equalsIgnoreCase(tipo)) {
                    String genero = rs.getString("genero");
                    int duracao = rs.getInt("duracao");
                    lista.add(new Filme(id, titulo, genero, duracao));
                } else {
                    int temporadas = rs.getInt("temporadas");
                    lista.add(new Serie(id, titulo, temporadas));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}