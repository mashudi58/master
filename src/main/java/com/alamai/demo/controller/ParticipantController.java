package com.alamai.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alamai.demo.models.Participant;
import com.alamai.demo.repository.ParticipantRepository;

@RestController
public class ParticipantController {
	
	@Autowired
	ParticipantRepository repository;

	@GetMapping("/get/participant/all")
	public ResponseEntity findAllParticipant() {
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping("/participant")
	public ResponseEntity addParticipant(@RequestBody Participant participant) {
		
		return ResponseEntity.ok(repository.save(participant));
	}
}
