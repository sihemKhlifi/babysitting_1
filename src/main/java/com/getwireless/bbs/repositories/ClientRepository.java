package com.getwireless.bbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getwireless.bbs.entities.Client;



public interface ClientRepository extends JpaRepository<Client, Integer> {

}
