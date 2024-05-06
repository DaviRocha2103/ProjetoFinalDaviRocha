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
import model.bean.ClientesDTO;
/**
 *
 * @author Senai
 */
public class ClientesDAO {
    public List<ClientesDTO> read() {

        List<ClientesDTO> clientes = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("select * from clientes");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ClientesDTO cliente = new ClientesDTO();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                clientes.add(cliente);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {

        }
        
        return clientes;
    }
     
      public void insert(ClientesDTO clientes) {

        try (Connection conexao = Conexao.conectar();
                PreparedStatement stmt = conexao.prepareStatement("insert into clientes(nome, senha, email, cpf, telefone, status) value (?,?,?,?,?, 1)")) {

            stmt.setString(1, clientes.getNome());
            stmt.setString(2, clientes.getSenha());
            stmt.setString(3, clientes.getEmail());
            stmt.setString(4, clientes.getCpf());
            stmt.setString(5, clientes.getTelefone());
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException a) {
            a.printStackTrace();
        }

    }
      
     public ClientesDTO buscarLogin(ClientesDTO cliente) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT idCliente, status FROM clientes WHERE nome = ? AND senha = ?");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSenha());
            
            rs = stmt.executeQuery();
            if(rs.next()){
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setStatus(rs.getInt("status"));
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return cliente;
    }
}

