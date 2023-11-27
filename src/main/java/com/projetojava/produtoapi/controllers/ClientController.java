package com.projetojava.produtoapi.controllers;

import com.projetojava.produtoapi.dtos.ClientDTO;
import com.projetojava.produtoapi.models.ClientModel;
import com.projetojava.produtoapi.services.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientModel> createClient(@RequestBody ClientDTO clientDTO) {
        ClientModel clientModel = new ClientModel();
        BeanUtils.copyProperties(clientDTO, clientModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.saveClient(clientModel));
    }

    @GetMapping
    public ResponseEntity<List<ClientModel>> getAllClients() {
        List<ClientModel> clients = clientService.getAllClients();
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClientById(@PathVariable UUID id) {
        Optional<ClientModel> clientOptional = clientService.getClientById(id);
        if (clientOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(clientOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable UUID id, @RequestBody ClientDTO clientDTO) {
        Optional<ClientModel> clientOptional = clientService.getClientById(id);
        if (clientOptional.isPresent()) {
            ClientModel existingClient = clientOptional.get();
            BeanUtils.copyProperties(clientDTO, existingClient);
            return ResponseEntity.status(HttpStatus.OK).body(clientService.saveClient(existingClient));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable UUID id) {
        Optional<ClientModel> clientOptional = clientService.getClientById(id);
        if (clientOptional.isPresent()) {
            clientService.deleteClient(id);
            return ResponseEntity.status(HttpStatus.OK).body("Client deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.");
        }
    }
}
