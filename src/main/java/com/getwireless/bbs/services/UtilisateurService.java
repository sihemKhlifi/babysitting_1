package com.getwireless.bbs.services;

import com.getwireless.bbs.model.MessageResponse;
import com.getwireless.bbs.model.passwordDto;

public interface UtilisateurService {
	
	
	public MessageResponse changePassword(passwordDto pwDto);
	
	

}
