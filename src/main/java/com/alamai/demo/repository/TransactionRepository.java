package com.alamai.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.alamai.demo.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction>{

	List<Transaction> findAllByTransactionDateBetween(Date endDate, Date startDate);
	List<Transaction> findAllByParticipantId(Long participantId);

}
