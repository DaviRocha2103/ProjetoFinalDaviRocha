package model.bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Senai
 */
public class ClientesDTO {
    private static int idCliente;
    private String nome;
    private String senha;
    private String email;
    private String cpf;
    private String telefone;
    private int status;

    public ClientesDTO() {
    }

    public ClientesDTO(int idCliente, String nome, String senha, String email, String cpf, String telefone, int status) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.status = status;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
}


