package com.example.votacaobbb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.votacaobbb.model.ParticipanteModel;

public interface ParticipanteRepository extends MongoRepository<ParticipanteModel, String> {

}
