package com.projetojava.produtoapi.repositories;

import com.projetojava.produtoapi.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientModel, UUID> {
}
