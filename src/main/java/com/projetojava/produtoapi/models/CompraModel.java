package com.projetojava.produtoapi.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class CompraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCompra;

    private int quantidade;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idClient")
    private ClientModel client;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    private ProductModel product;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public UUID getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(UUID idCompra) {
        this.idCompra = idCompra;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }
}
