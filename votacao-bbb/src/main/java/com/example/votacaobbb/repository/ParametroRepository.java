package com.example.votacaobbb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.votacaobbb.model.ParametroModel;

public interface ParametroRepository extends MongoRepository<ParametroModel, String> {

}
