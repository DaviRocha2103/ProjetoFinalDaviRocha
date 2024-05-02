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
import model.bean.PedidosDTO;
/**
 *
 * @author Senai
 */
public class PedidosDAO {
    public List<PedidosDTO> read() {

        List<PedidosDTO> pedidos = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("select * from pedido");
            rs = stmt.executeQuery();

            while (rs.next()) {
                PedidosDTO pedido = new PedidosDTO();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setIdCliente(rs.getInt("idCliente"));
                pedido.setQuantidade(rs.getInt("quantidade"));
                pedido.setStatusPedido(rs.getString("statusPedido"));
                pedido.setEnderecoEntrega(rs.getString("enderecoPedido"));
                pedido.setTotalPedido(rs.getFloat("totalPedido"));
                pedidos.add(pedido);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {

        }
        
        return pedidos;
    }
     
      public void insert(PedidosDTO pedidos) {

        try (Connection conexao = Conexao.conectar();
                PreparedStatement stmt = conexao.prepareStatement("insert into pedido(idCliente, quantidade, statusPedido, enderecoEntrega, totalPedido) value (?,?,?,?,?)")) {

            stmt.setInt(1, pedidos.getIdCliente());
            stmt.setInt(2, pedidos.getQuantidade());
            stmt.setString(3, pedidos.getStatusPedido());
            stmt.setString(4, pedidos.getEnderecoEntrega());
            stmt.setFloat(5, pedidos.getTotalPedido());
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException a) {
            a.printStackTrace();
        }

    }
      
      public void deletar(PedidosDTO pedido) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("delete from pedido where idPedido = ?");
            stmt.setInt(1, pedido.getIdPedido());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      
        public void edit(PedidosDTO pedidoUpd){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("UPDATE pedido SET idCliente = ?, quantidade = ?, statusPedido = ?, enderecoPedido = ?, totalPedido = ? WHERE idPedido = ?");
            stmt.setInt(1, pedidoUpd.getIdCliente());
            stmt.setInt(2, pedidoUpd.getQuantidade());
            stmt.setString(3, pedidoUpd.getStatusPedido());
            stmt.setString(4, pedidoUpd.getEnderecoEntrega());
            stmt.setFloat(5, pedidoUpd.getTotalPedido());
            stmt.setInt(6, pedidoUpd.getIdPedido());
            
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
     
}