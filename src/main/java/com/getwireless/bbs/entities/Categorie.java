package com.getwireless.bbs.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;


@Entity
@Data
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	
	
	@ManyToOne
	private Categorie parent;
	
	@ManyToMany
	private List<Fournisseur> fournisseurs;
	
	@OneToMany(mappedBy="categorie")
	private List<Annonce> annonces;

	

}
