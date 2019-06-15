package br.com.vv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.vv.domain.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
