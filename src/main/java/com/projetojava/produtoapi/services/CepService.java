package com.projetojava.produtoapi.services;

import com.projetojava.produtoapi.dtos.CepResultDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    public CepResultDTO getCepResultViaCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CepResultDTO> resp =
                restTemplate.
                        getForEntity(
                                String.format("https://viacep.com.br/ws/%s/json/", cep),
                                CepResultDTO.class);
        return resp.getBody();
    }
}
