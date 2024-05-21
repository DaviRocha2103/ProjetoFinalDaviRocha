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

import model.bean.ProdutosDTO;
/**
 *
 * @author Senai
 */
public class ProdutosDAO {
    public List<ProdutosDTO> read() {

        List<ProdutosDTO> produtos = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("select * from produtos");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getInt("categoria"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setImagem(rs.getString("imagem"));
                produtos.add(produto);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {

        }
        
        return produtos;
    }
     
      public void insert(ProdutosDTO produtos) {

        try (Connection conexao = Conexao.conectar();
                PreparedStatement stmt = conexao.prepareStatement("insert into produtos(nome, categoria, descricao, preco, quantidade,imagem) value (?,?,?,?,?,?)")) {

            stmt.setString(1, produtos.getNome());
            stmt.setInt(2, produtos.getCategoria());
            stmt.setString(3, produtos.getDescricao());
            stmt.setFloat(4, produtos.getPreco());
            stmt.setInt(5, produtos.getQuantidade());
            stmt.setString(6, produtos.getImagem());
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException a) {
            a.printStackTrace();
        }

    }
      
      public List<ProdutosDTO> buscaProdutos(String busca) {
        List<ProdutosDTO> resultadoBusca = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE nome LIKE ? OR descricao LIKE ?");
            stmt.setString(1, busca);
            stmt.setString(2, busca);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                ProdutosDTO prod = new ProdutosDTO();
                prod.setIdProduto(rs.getInt("idProduto"));
                prod.setNome(rs.getString("nome"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getFloat("preco"));
                prod.setImagem(rs.getString("imagem"));
                
                resultadoBusca.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultadoBusca;
    }
      
       public List<ProdutosDTO> buscaCategoria (int categoria) {
        List<ProdutosDTO> resultadoBusca = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE categoria = ?");
            stmt.setInt(1, categoria);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                ProdutosDTO prod = new ProdutosDTO();
                prod.setIdProduto(rs.getInt("idProduto"));
                prod.setNome(rs.getString("nome"));
                prod.setCategoria(rs.getInt("categoria"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getFloat("preco"));
                prod.setImagem(rs.getString("imagem"));
                
                resultadoBusca.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultadoBusca;
    }
     
}