package com.projetojava.produtoapi.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class CompraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCompra;

    private UUID idProduto;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel client;

    @ManyToMany
    @JoinTable(
            name = "compra_produto",
            joinColumns = @JoinColumn(name = "compra_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<ProductModel> produtos;

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

    public UUID getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(UUID idProduto) {
        this.idProduto = idProduto;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }
}
