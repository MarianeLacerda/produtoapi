package com.projetojava.produtoapi.dtos;

public class ClientDTO {
    private String nome;
    private String cep;

    private String compra;

    // Construtores, getters e setters


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }

    // Outros getters e setters para os campos adicionais, se houver
}
