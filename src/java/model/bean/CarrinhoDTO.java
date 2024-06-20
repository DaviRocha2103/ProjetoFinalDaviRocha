/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Senai
 */
public class CarrinhoDTO {
    private int idCarrinho;
    private int idClientes;
    private int idProduto;
    private float preco;
    private float total;
    private int quantidade;
    private String imagem;

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public CarrinhoDTO(int idCarrinho, int idClientes, int idProduto, float preco, float total, int quantidade, String imagem) {
        this.idCarrinho = idCarrinho;
        this.idClientes = idClientes;
        this.idProduto = idProduto;
        this.preco = preco;
        this.total = total;
        this.quantidade = quantidade;
        this.imagem = imagem;
    }

    public CarrinhoDTO() {
    }

}
