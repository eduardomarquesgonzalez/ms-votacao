package com.example.votacaobbb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.votacaobbb.model.ParticipanteModel;
import com.example.votacaobbb.service.VotacaoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/votacao")
@AllArgsConstructor
public class VotacaoController {

	private final VotacaoService servico;

	@PostMapping
	public ResponseEntity<String> votar(@RequestBody ParticipanteModel participante) {
		servico.adicionarEvento(participante);
		return ResponseEntity.ok("Voto Computado");
	}
}
