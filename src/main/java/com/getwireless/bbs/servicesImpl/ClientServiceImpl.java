package com.getwireless.bbs.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.getwireless.bbs.entities.Client;
import com.getwireless.bbs.model.MessageResponse;
import com.getwireless.bbs.repositories.ClientRepository;
import com.getwireless.bbs.repositories.UtilisateurRepository;
import com.getwireless.bbs.services.ClientService;



@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@Override
	public MessageResponse register(Client client) {
		
		boolean exist=utilisateurRepository.existByEmail(client.getEmail());
		if(exist) {
			return new MessageResponse(false, "email exist déja" );
		}
		

		exist=utilisateurRepository.existByLogin(client.getLogin());
		if(exist) {
			return new MessageResponse(false, "login exist déja" );
		}
		 
		String cryptedPassword=passwordEncoder.encode(client.getPassword());
		
		client.setPassword(cryptedPassword);
		
		clientRepository.save(client);
	        
		return new MessageResponse(true ,"opération effectuée avec succès " );
	}

	@Override
	public MessageResponse update(Client client) {
		
		boolean exist=utilisateurRepository.existByEmailAndId(client.getEmail(),client.getId());
		if(!exist) {
			exist=utilisateurRepository.existByEmail(client.getEmail());
			if(exist) {
			return new MessageResponse(false, "email exist déja" );
			}
		}
		

		
		if(exist) {
			return new MessageResponse(false, "login exist déja" );
		}
		
		exist=utilisateurRepository.existByLoginAndById(client.getLogin(),client.getId());
		if(!exist) {
			
		exist=utilisateurRepository.existByLogin(client.getLogin());
		if(exist) {
			return new MessageResponse(false, "login exist déja" );
		}
		
		
		clientRepository.save(client);
	        
	
	}

		return new MessageResponse(true ,"opération effectuée avec succès " );

	}

	

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Client findById(Integer id) {
		
		return clientRepository.findById(id).orElse(null);
	}

}
