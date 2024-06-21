/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.EstoqueDTO;

/**
 *
 * @author Senai
 */
public class EstoqueDAO {
     public List<EstoqueDTO> Tamanhos(String nome){
        List<EstoqueDTO> tamanhos = new ArrayList();
        
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT produtos.nome AS nome" +
            "FROM produtos\n" +
            "JOIN estoque ON produtos.nome = estoque.nome\n" +
            "WHERE produtos.nome = ?");
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return tamanhos;
    }
    
    public int Quantidade(String nome){
        int quantidade_disponivel = 0;
        
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("CALL verificar_estoque(?);");
            stmt.setString(1, nome);
            rs = stmt.executeQuery();

            if (rs.next()) {                
                quantidade_disponivel = (rs.getInt("quantidade"));
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return quantidade_disponivel;
    }
}
