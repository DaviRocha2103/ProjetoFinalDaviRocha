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
public class PedidosDTO {
    private int idPedido;
    private int idCliente;
    private int quantidade;
    private String statusPedido;
    private String enderecoEntrega;
    private float totalPedido;

    public PedidosDTO() {
    }

    public PedidosDTO(int idPedido, int idCliente, int quantidade, String statusPedido, String enderecoEntrega, float totalPedido) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.quantidade = quantidade;
        this.statusPedido = statusPedido;
        this.enderecoEntrega = enderecoEntrega;
        this.totalPedido = totalPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public float getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(float totalPedido) {
        this.totalPedido = totalPedido;
    }
    
}
