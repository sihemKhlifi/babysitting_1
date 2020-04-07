package com.getwireless.bbs.services;

import java.util.List;

import com.getwireless.bbs.entities.Client;
import com.getwireless.bbs.model.MessageResponse;

public interface ClientService {
	
	public MessageResponse register(Client client);
	
	public MessageResponse update(Client client);
	
	
	 public List<Client> findAll();
	 
	 public Client findById(Integer id);
	 
	

}
