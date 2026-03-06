package io.github.fatec.introducao.repository;

import io.github.fatec.introducao.model.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PessoaRepository extends MongoRepository<Pessoa, String> {

}