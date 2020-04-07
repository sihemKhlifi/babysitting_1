package com.getwireless.bbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getwireless.bbs.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	
	boolean existByEmail(String email);
	
	boolean existByLogin(String login);

	boolean existByEmailAndId(String email, Integer id);

	boolean existByLoginAndById(String login, Integer id);



}
