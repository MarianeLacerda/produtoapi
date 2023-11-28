package com.projetojava.produtoapi.services;

import com.projetojava.produtoapi.models.ProductModel;
import com.projetojava.produtoapi.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<ProductModel> getProductById(UUID id) {
        return productRepository.findById(id);
    }

    public ProductModel saveProduct(ProductModel product) {
        return productRepository.save(product);
    }

    public List<ProductModel> getProductsByIds(List<UUID> productIds) {
        return productIds.stream()
                .map(productId -> getProductById(productId).orElse(null))
                .collect(Collectors.toList());
    }

    public ProductModel updateProduct(UUID id, ProductModel updatedProduct) {
        Optional<ProductModel> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            ProductModel product = existingProduct.get();
            BeanUtils.copyProperties(updatedProduct, product);
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found.");
        }
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
