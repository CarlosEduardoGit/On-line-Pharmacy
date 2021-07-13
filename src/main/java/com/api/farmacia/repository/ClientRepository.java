package com.api.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.farmacia.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
