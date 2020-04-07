package com.getwireless.bbs.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;


@Data
@Entity
public class Client extends Utilisateur {
	
	@OneToMany(mappedBy="client")
	private List<Annonce> annonces;
	
	
	

}
