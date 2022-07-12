package com.alamai.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alamai.demo.models.Participant;
import com.alamai.demo.models.Transaction;
import com.alamai.demo.repository.ParticipantRepository;
import com.alamai.demo.repository.TransactionRepository;

@RestController
public class TransaksiController {
	
	@Autowired 
	private ParticipantRepository participantRepository;	
	
	@Autowired 
	private TransactionRepository repository;	
	
	@GetMapping("/transaction/testo")
	public String testo() {
		return "testo transaksi";
	}

	@GetMapping("/transaction/getByParticipantId")
	public ResponseEntity findAllTransactionByParticipantId(@Nullable @RequestBody  Long participantId) {

		return ResponseEntity.ok(repository.findAllByParticipantId(participantId));
	}
	
	@GetMapping("/transaction/getTransactionBetweenDate")
	public ResponseEntity findAllTransactionBetweenDate(@RequestBody Map<String, Date> req) {

		//DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
		Date startDate = req.get("startDate");
		Date endDate = req.get("endDate");
		
		return ResponseEntity.ok(repository.findAllByTransactionDateBetween( startDate, endDate));

	}
	
	@PostMapping("/transaction")
	public ResponseEntity addTransaction(@RequestBody Transaction transaction) {
		Participant p = participantRepository.findById(transaction.getParticipantId()).orElseThrow();
		
		if (transaction.getTransactionType().equals("setor") ) {
			p.setSaldo(p.getSaldo()+transaction.getTransactionValue()); 
		}else if (transaction.getTransactionType().equals("pinjam") || transaction.getTransactionType().equals("tarik")) {
			p.setSaldo(p.getSaldo()-transaction.getTransactionValue()); 
		}
		transaction.setParticipant(p);
		
		return ResponseEntity.ok(repository.save(transaction) );
	}

}
