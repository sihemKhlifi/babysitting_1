package com.getwireless.bbs.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;



@Entity
@Data
public class Reglement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String modePaiment;
	private Date dateReglement;
	private double mantant;
	
	@OneToOne
	private Annonce annonce;
}
