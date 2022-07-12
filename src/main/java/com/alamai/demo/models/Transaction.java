package com.alamai.demo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Transaction implements Serializable{

	@Id
	private Long transactionId;

	private String transactionType;
	private Date transactionDate;
	private String transactionNote;
	private Integer transactionValue;
	
	@ManyToOne()
	@JoinColumn(name="participant_id")
	private Participant participant;	
	
	@Column(name="participant_id", insertable = false, updatable = false)
	private Long participantId;

}
