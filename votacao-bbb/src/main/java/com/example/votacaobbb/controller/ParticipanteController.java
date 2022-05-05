package com.example.votacaobbb.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.votacaobbb.model.ParticipanteModel;
import com.example.votacaobbb.repository.ParticipanteRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/participantes")
@AllArgsConstructor
public class ParticipanteController {

	private final ParticipanteRepository repository;
	

	@PostMapping("/salvar")
	public ResponseEntity<ParticipanteModel> salvar(@RequestBody ParticipanteModel participante) {
		ParticipanteModel save = repository.save(participante);
		return ResponseEntity.ok(save);
	}

	@GetMapping("consultar")
	public ResponseEntity<ParticipanteModel> consultar(@RequestParam String id) {
		Optional<ParticipanteModel> consultaID = repository.findById(id);
		if (consultaID.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(consultaID.get());

	}
}