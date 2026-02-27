package io.github.fatec.introducao.controller;

import io.github.fatec.introducao.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @PostMapping
    public PessoaResponse criar(@RequestBody PessoaRequestPost request) {

        PessoaResponse response = new PessoaResponse();
        response.setId(UUID.randomUUID().toString());
        response.setNome(request.getNome());

        return response;
    }

    @PutMapping
    public PessoaResponse atualizar(@RequestBody PessoaRequestPut request) {

        PessoaResponse response = new PessoaResponse();
        response.setId(request.getId());
        response.setNome(request.getNome());

        return response;
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable String id) {

        return "usuario: " + id + " deletado";
    }
}