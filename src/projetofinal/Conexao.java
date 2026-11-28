
package projetofinal;
import java.sql.*;

public class Conexao {
    static Connection conexao = null;
    String user = "root";
    String password = "Password";
    String database = "projeto_final_adocao";
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