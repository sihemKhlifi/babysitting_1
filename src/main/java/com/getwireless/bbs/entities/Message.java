package com.getwireless.bbs.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Entity
@Data
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Temporal(TemporalType.DATE)
	private Date dateMessage;
	private String objet;
	@ManyToOne
	private Fournisseur fournisseur;
	
	@ManyToOne
	 private Annonce annonce;
	
	

}
