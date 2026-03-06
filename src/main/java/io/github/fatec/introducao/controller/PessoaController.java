package io.github.fatec.introducao.controller;

import io.github.fatec.introducao.dto.*;
import io.github.fatec.introducao.model.Pessoa;
import io.github.fatec.introducao.repository.PessoaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaRepository repository;

    public PessoaController(PessoaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public PessoaResponse criar(@RequestBody PessoaRequestPost request) {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(request.getNome());

        pessoa = repository.save(pessoa);

        PessoaResponse response = new PessoaResponse();
        response.setId(pessoa.getId());
        response.setNome(pessoa.getNome());

        return response;
    }

    @PutMapping
    public PessoaResponse atualizar(@RequestBody PessoaRequestPut request) {

        Pessoa pessoa = new Pessoa();
        pessoa.setId(request.getId());
        pessoa.setNome(request.getNome());

        pessoa = repository.save(pessoa);

        PessoaResponse response = new PessoaResponse();
        response.setId(pessoa.getId());
        response.setNome(pessoa.getNome());

        return response;
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable String id) {

        repository.deleteById(id);

        return "usuario: " + id + " deletado";
    }
}