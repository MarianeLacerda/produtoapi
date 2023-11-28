package com.projetojava.produtoapi.controllers;

import com.projetojava.produtoapi.dtos.ClientDTO;
import com.projetojava.produtoapi.dtos.CompraDTO;
import com.projetojava.produtoapi.models.ClientModel;
import com.projetojava.produtoapi.models.CompraModel;
import com.projetojava.produtoapi.models.ProductModel;
import com.projetojava.produtoapi.services.CompraService;
import com.projetojava.produtoapi.services.ProductService;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ProductService productService;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    private ProductModel product;


    @PostMapping
    public ResponseEntity<CompraModel> createCompra(@RequestBody CompraDTO compraDTO) {
        CompraModel compraModel = new CompraModel();
        return ResponseEntity.status(HttpStatus.CREATED).body(compraService.createCompra(compraDTO));
    }

    @GetMapping
    public ResponseEntity<List<CompraModel>> getAllCompras() {
        return ResponseEntity.ok(compraService.getAllCompras());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCompraById(@PathVariable UUID id) {
        Optional<CompraModel> compraOptional = compraService.getCompraById(id);
        if (compraOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(compraOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra not found.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCompra(@PathVariable UUID id, @RequestBody CompraDTO compraDTO) {
        Optional<CompraModel> compraOptional = compraService.getCompraById(id);
        if (compraOptional.isPresent()) {
            CompraModel existingCompra = compraOptional.get();
            BeanUtils.copyProperties(compraDTO, existingCompra);
            return ResponseEntity.status(HttpStatus.OK).body(compraService.saveCompra(existingCompra));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCompra(@PathVariable UUID id) {
        Optional<CompraModel> compraOptional = compraService.getCompraById(id);
        if (compraOptional.isPresent()) {
            compraService.deleteCompra(id);
            return ResponseEntity.status(HttpStatus.OK).body("Compra deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra not found.");
        }
    }
}
