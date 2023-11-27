package com.projetojava.produtoapi.services;

import com.projetojava.produtoapi.dtos.CepResultDTO;
import com.projetojava.produtoapi.models.ClientModel;
import com.projetojava.produtoapi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CepService cepService;

    public ClientModel saveClient(ClientModel client) {
        ClientModel savedClient = clientRepository.save(client);
        CepResultDTO cepResult = cepService.getCepResultViaCep(client.getCep());
        savedClient.setLogradouro(cepResult.getLogradouro());
        savedClient.setBairro(cepResult.getBairro());
        savedClient.setLocalidade(cepResult.getLocalidade());
        savedClient.setUf(cepResult.getUf());
        return clientRepository.save(savedClient);
    }

    public List<ClientModel> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<ClientModel> getClientById(UUID id) {
        return clientRepository.findById(id);
    }

    public void deleteClient(UUID id) {
        clientRepository.deleteById(id);
    }
}
