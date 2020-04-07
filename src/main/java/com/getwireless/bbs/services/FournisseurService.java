package com.getwireless.bbs.services;

import java.util.List;

import com.getwireless.bbs.entities.Fournisseur;
import com.getwireless.bbs.model.MessageResponse;

public interface FournisseurService {
	
	public MessageResponse register(Fournisseur fournisseur);
	
	public MessageResponse update(Fournisseur fournisseur);
	
	
	 public List<Fournisseur> findAll();
	 
	 public Fournisseur findById(Integer id);
	 
	

}
