package com.projetojava.produtoapi.repositories;

import com.projetojava.produtoapi.models.CompraModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompraRepository extends JpaRepository<CompraModel, UUID> {
}
