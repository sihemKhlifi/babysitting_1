package com.getwireless.bbs.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;



@Entity
@Data
public class Annonce {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private String titre;
	private String description;
	
	@ManyToOne
	private Categorie categorie;
	
	@ManyToOne
	private Client client;
	
	@OneToOne(mappedBy = "annonce")
	private Reglement reglement;
	
	
	@OneToMany(mappedBy = "annonce")
	private List<Message> messages;


}
