package com.projetojava.produtoapi.controllers;


import com.projetojava.produtoapi.dtos.CepResultDTO;
import com.projetojava.produtoapi.services.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consulta-cep")
public class CepController {

    @Autowired
    private CepService cepService;

    @GetMapping("{cep}")
    public CepResultDTO consultaCep (@PathVariable("cep") String cep) {
        return cepService.getCepResultViaCep(cep);
    }


}