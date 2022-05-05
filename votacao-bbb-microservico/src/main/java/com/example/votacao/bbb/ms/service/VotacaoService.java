package com.example.votacao.bbb.ms.service;

import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.votacao.bbb.ms.model.ParticipanteModel;
import com.example.votacao.bbb.ms.model.VotacaoModel;
import com.example.votacao.bbb.ms.repository.VotacaoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class VotacaoService {

	private final VotacaoRepository repository;

	@KafkaListener(topics = "votacao", groupId = "MicroServicoVotacao")
	public void executar(ConsumerRecord<String, String> registro) {

		String participanteStr = registro.value();
		log.info("voto recebido [{}]", participanteStr);

		ParticipanteModel participante = null;
		ObjectMapper mapper = new ObjectMapper();

		try {
			participante = mapper.readValue(participanteStr, ParticipanteModel.class);
		} catch (JsonProcessingException ex) {
			log.info("Falha ao converter voto", participanteStr, ex);
		}
		
		VotacaoModel votacao = new VotacaoModel(null, participante, new Date());
		VotacaoModel save = repository.save(votacao);
		log.info("Voto registrado com sucesso [id={}]", save.getId(), save.getDataHora());
	}

}
