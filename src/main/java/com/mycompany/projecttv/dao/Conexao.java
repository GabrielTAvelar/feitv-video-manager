package com.mycompany.projecttv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public static Connection getConexao() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/feitv_db", "postgres", "13556789");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
    public static Connection getConnection() {
        return getConexao();
    }
}