/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetofinal;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
        
public class PessoaDAO {
    Connection conexao;

    public PessoaDAO(){
        conexao = new Conexao().getConexao();        
    }
    
           
    //inserir os dados de uma pessoa no mysql
    public void inserir(Pessoa p){
      try{   
        String sql = "insert into Pessoa (id, nome, cpf, idade) values ( ?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setInt(1, p.getId());
        ps.setString(2, p.getNome());
        ps.setString(3, p.getCpf());
        ps.setInt(4, p.getIdade());
        
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Cadastro de pessoa realizado");
      }catch(Exception e){
          System.out.println("Erro na insercao: "+e);
      }
    }
    
        
   public ArrayList<Pessoa> consultarTodos(){
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        
        try{
            String sql = "select * from pessoa"; 
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Pessoa p = new Pessoa(rs.getInt("id"), rs.getInt("idade"), rs.getString("nome"), rs.getString("cpf"));
               
                pessoas.add(p);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na consulta");
        }
        
        return pessoas;
    }
    
}

