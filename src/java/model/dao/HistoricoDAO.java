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
import model.bean.HistoricoDTO;
/**
 *
 * @author Senai
 */
public class HistoricoDAO {
    public List<HistoricoDTO> read() {

        List<HistoricoDTO> historicos = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("select * from historico");
            rs = stmt.executeQuery();

            while (rs.next()) {
                HistoricoDTO historico = new HistoricoDTO();
                historico.setIdItem(rs.getInt("idItem"));
                historico.setDataPedido(rs.getDate("dataPedido"));
                historico.setIdPedido(rs.getInt("idPedido"));
                historico.setIdProduto(rs.getInt("idProduto"));
                historico.setQuantidade(rs.getInt("quantidade"));
                historico.setPrecoUnitario(rs.getFloat("precoUnitario"));
                historicos.add(historico);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {

        }
        
        return historicos;
    }
     
      public void insert(HistoricoDTO historicos) {

        try (Connection conexao = Conexao.conectar();
                PreparedStatement stmt = conexao.prepareStatement("insert into historio(dataPedido, idPedido, idProduto, quantidade, precoUnitario) value (?,?,?,?,?)")) {

            stmt.setDate(1, historicos.getDataPedido());
            stmt.setInt(2, historicos.getIdPedido());
            stmt.setInt(3, historicos.getIdProduto());
            stmt.setInt(4, historicos.getQuantidade());
            stmt.setFloat(5, historicos.getPrecoUnitario());
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException a) {
            a.printStackTrace();
        }

    }
      
      public void deletar(HistoricoDTO historico) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("delete from historico where idItem = ?");
            stmt.setInt(1, historico.getIdItem());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      
        public void edit(HistoricoDTO historicoUpd){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("UPDATE historico SET dataPedido = ?, idPedido = ?, idProduto = ?, quantidade = ?, precoUnitario = ? WHERE idItem = ?");
            stmt.setDate(1, historicoUpd.getDataPedido());
            stmt.setInt(2, historicoUpd.getIdPedido());
            stmt.setInt(3, historicoUpd.getIdProduto());
            stmt.setInt(4, historicoUpd.getQuantidade());
            stmt.setFloat(5, historicoUpd.getPrecoUnitario());
            stmt.setInt(6, historicoUpd.getIdItem());
            
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
     
}