package com.getwireless.bbs.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.getwireless.bbs.entities.Fournisseur;
import com.getwireless.bbs.model.MessageResponse;
import com.getwireless.bbs.repositories.FournisseurRepository;
import com.getwireless.bbs.repositories.UtilisateurRepository;
import com.getwireless.bbs.services.FournisseurService;



@Service
public class FournisseurServiceImpl implements FournisseurService {
	
	@Autowired
	private FournisseurRepository fournisseurRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@Override
	public MessageResponse register(Fournisseur fournisseur) {
		
		boolean exist=utilisateurRepository.existByEmail(fournisseur.getEmail());
		if(exist) {
			return new MessageResponse(false, "email exist déja" );
		}
		

		exist=utilisateurRepository.existByLogin(fournisseur.getLogin());
		if(exist) {
			return new MessageResponse(false, "login exist déja" );
		}
		 
		String cryptedPassword=passwordEncoder.encode(fournisseur.getPassword());
		
		fournisseur.setPassword(cryptedPassword);
		
		fournisseurRepository.save(fournisseur);
	        
		return new MessageResponse(true ,"opération effectuée avec succès " );
	}

	@Override
	public MessageResponse update(Fournisseur fournisseur) {
		
		boolean exist=utilisateurRepository.existByEmailAndId(fournisseur.getEmail(),fournisseur.getId());
		if(!exist) {
			exist=utilisateurRepository.existByEmail(fournisseur.getEmail());
			if(exist) {
			return new MessageResponse(false, "email exist déja" );
			}
		}
		

		exist=utilisateurRepository.existByLogin(fournisseur.getLogin());
		if(exist) {
			return new MessageResponse(false, "login exist déja" );
		}
		
		exist=utilisateurRepository.existByLoginAndById(fournisseur.getLogin(),fournisseur.getId());
		if(!exist) {
			
		exist=utilisateurRepository.existByLogin(fournisseur.getLogin());
		if(exist) {
			return new MessageResponse(false, "login exist déja" );
		}
		
		
		fournisseurRepository.save(fournisseur);
	        
	
	}

		return new MessageResponse(true ,"opération effectuée avec succès " );

	}

	

	@Override
	public List<Fournisseur> findAll() {
		// TODO Auto-generated method stub
		return fournisseurRepository.findAll();
	}

	@Override
	public Fournisseur findById(Integer id) {
		
		return fournisseurRepository.findById(id).orElse(null);
	}

}
