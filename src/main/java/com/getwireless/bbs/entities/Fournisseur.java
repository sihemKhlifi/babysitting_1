package com.getwireless.bbs.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Data
@Entity
public class Fournisseur extends Utilisateur {

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String sexe ;
	private String niveauEtude;
	private String langue;
	
	
	@ManyToMany
	private List<Categorie> categories;

	@OneToMany(mappedBy = "fournisseur")
	private List<Message> messages;

	
	
	
}
