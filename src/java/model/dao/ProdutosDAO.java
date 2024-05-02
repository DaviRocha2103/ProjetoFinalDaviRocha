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
                PreparedStatement stmt = conexao.prepareStatement("insert into produtos(quantidade, statusPedido, enderecoEntrega, totalPedido) value (?,?,?,?)")) {

            stmt.setString(1, produtos.getNome());
            stmt.setString(2, produtos.getDescricao());
            stmt.setFloat(3, produtos.getPreco());
            stmt.setInt(4, produtos.getQuantidade());
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException a) {
            a.printStackTrace();
        }

    }
      
      public void deletar(ProdutosDTO produto) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("delete from produtos where idProduto = ?");
            stmt.setInt(1, produto.getIdProduto());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      
        public void edit(ProdutosDTO produtosUpd){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("UPDATE produtos SET nome = ?, descricao = ?, preco = ?, quantidade = ? WHERE idProduto = ?");
            stmt.setString(2, produtosUpd.getNome());
            stmt.setString(3, produtosUpd.getDescricao());
            stmt.setFloat(4, produtosUpd.getPreco());
            stmt.setInt(5, produtosUpd.getQuantidade());
            stmt.setInt(6, produtosUpd.getIdProduto());
            
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
     
}