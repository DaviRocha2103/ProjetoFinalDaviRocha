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
import model.bean.CarrinhoDTO;
import model.bean.ClientesDTO;

/**
 *
 * @author Senai
 */
/*Creditos Bruno de Souza*/
public class CarrinhoDAO {
    public List<CarrinhoDTO> ler(int id) {
        List<CarrinhoDTO> carrinho = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM carrinho WHERE idCarrinho = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                CarrinhoDTO carinho = new CarrinhoDTO();
                carinho.setIdCarrinho(rs.getInt("idCarrinho"));
                carinho.setIdClientes(rs.getInt("idClientes"));
                carinho.setIdProduto(rs.getInt("idProduto"));
                carinho.setPreco(rs.getFloat("preco"));
                carinho.setTotal(rs.getFloat("total"));
                carinho.setQuantidade(rs.getInt("quantidade"));
                carinho.setTotal(rs.getFloat("total"));
                carrinho.add(carinho);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return carrinho;
    }

    public void att(int quantidade, int id, float total) {

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("UPDATE carrinho SET quantidade = ? , total = ? WHERE idCarrinho = ?");
            stmt.setInt(1, quantidade);
            stmt.setFloat(2, total);
            stmt.setInt(3, id);
            stmt.executeUpdate();

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("DELETE FROM carrinho WHERE idCarrinho = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(CarrinhoDTO carrinho) {

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("INSERT INTO carrinho (idClientes, idProduto, preco, total, quantidade) VALUES (?,?,?,?,?)");
            stmt.setInt(1, carrinho.getIdClientes());
            stmt.setInt(2, carrinho.getIdProduto());
            stmt.setFloat(3, carrinho.getPreco());
            stmt.setFloat(4, carrinho.getTotal());
            stmt.setInt(5, carrinho.getQuantidade());
            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CarrinhoDTO validação(CarrinhoDTO produto) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT idCarrinho, preco, total FROM carrinho WHERE IdProduto = ? AND quantidade = ?");
            stmt.setInt(1, produto.getIdProduto());
            stmt.setInt(2, produto.getQuantidade());
            rs = stmt.executeQuery();

            if (rs.next()) {
                produto.setIdCarrinho(rs.getInt("idCarrinho")); 
                produto.setTotal(rs.getFloat("total"));
                produto.setPreco(rs.getFloat("preco"));
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produto;
    }

    public Float Total(int idCliente) {
        Float total_carrinho = null;

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT SUM(total) as total_soma FROM carrinho WHERE idClientes = ?");
            stmt.setInt(1, ClientesDTO.getIdCliente());
            rs = stmt.executeQuery();

            if (rs.next()) {
                total_carrinho = (rs.getFloat("total_soma"));
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total_carrinho;
    }

    public void limparCarrinho(ClientesDTO c) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("DELETE FROM carrinho WHERE idClientes = ?");
            stmt.setInt(1, c.getIdCliente());
            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
