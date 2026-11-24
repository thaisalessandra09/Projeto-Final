/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetofinal;

import java.sql.*;
public class Conexao {
    static Connection conexao = null;
    String user = "root";
    String password = "password";
    String database = "aula";
    String url = "jdbc:mysql://localhost:3306/"+database;
    

    public Conexao() {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println("Conexao realizada com sucesso");
        } catch (SQLException e) {
            System.out.println("Problema na conexao: " + e.getMessage());
        }
    }

    public static Connection getConexao() {
        return conexao;
    }
}
