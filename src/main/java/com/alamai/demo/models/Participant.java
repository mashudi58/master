package com.alamai.demo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
public class Participant implements Serializable{

	@Id
	private Long participantId;

	private String fullname;
	
	private String address;
	
	@DateTimeFormat(pattern = "dd MM yyyy")
	private Date dob;

	private Integer saldo;
}
