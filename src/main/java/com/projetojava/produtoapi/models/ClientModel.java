package com.projetojava.produtoapi.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idClient;

    private String nome;
    private String cep;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<CompraModel> compras;

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

    public UUID getIdClient() {
        return idClient;
    }

    public void setIdClient(UUID idClient) {
        this.idClient = idClient;
    }

    public List<CompraModel> getCompras() {
        return compras;
    }

    public void setCompras(List<CompraModel> compras) {
        this.compras = compras;
    }
}
