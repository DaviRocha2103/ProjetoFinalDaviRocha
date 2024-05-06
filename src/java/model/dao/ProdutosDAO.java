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
import javax.swing.JOptionPane;
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
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
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
                PreparedStatement stmt = conexao.prepareStatement("insert into produtos(quantidade, statusPedido, enderecoEntrega, totalPedido, imagem) value (?,?,?,?,?)")) {

            stmt.setString(1, produtos.getNome());
            stmt.setString(2, produtos.getDescricao());
            stmt.setFloat(3, produtos.getPreco());
            stmt.setInt(4, produtos.getQuantidade());
            stmt.setBytes(5, produtos.getImagem());
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
                prod.setImagem(rs.getBytes("imagem"));
                
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
                prod.setImagem(rs.getBytes("imagem"));
                
                resultadoBusca.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultadoBusca;
    }
     
}