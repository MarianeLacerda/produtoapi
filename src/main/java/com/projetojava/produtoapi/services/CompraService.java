package com.projetojava.produtoapi.services;
import com.projetojava.produtoapi.dtos.CepResultDTO;
import com.projetojava.produtoapi.dtos.CompraDTO;
import com.projetojava.produtoapi.models.ClientModel;
import com.projetojava.produtoapi.models.CompraModel;
import com.projetojava.produtoapi.models.ProductModel;
import com.projetojava.produtoapi.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompraService {
    @Autowired
    private CompraRepository compraRepository;


    public CompraModel saveCompra(CompraModel compra) {
        CompraModel savedCompra = compraRepository.save(compra);

        return compraRepository.save(savedCompra);
    }

    public List<CompraModel> getAllCompras() {
        return compraRepository.findAll();
    }

    public CompraModel createCompra(CompraDTO dto) {
        ClientModel cliente = new ClientModel();
        cliente.setIdClient(dto.getIdCliente());

        ProductModel produto = new ProductModel();
        produto.setIdProduct(dto.getIdProduto());

        CompraModel compra = new CompraModel();

        compra.setClient(cliente);
        compra.setProduct(produto);
        compra.setQuantidade(dto.getQuantidade());
        return compraRepository.save(compra);
    }

    public Optional<CompraModel> getCompraById(UUID id) {
        return compraRepository.findById(id);
    }

    public void deleteCompra(UUID id) {
        compraRepository.deleteById(id);
    }
}
