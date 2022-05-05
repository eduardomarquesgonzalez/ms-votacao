package com.example.votacao.bbb.ms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.votacao.bbb.ms.model.VotacaoModel;

public interface VotacaoRepository extends MongoRepository<VotacaoModel, String> {

}
