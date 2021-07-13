package com.api.farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.farmacia.model.Client;
import com.api.farmacia.model.Product;
import com.api.farmacia.model.Store;
import com.api.farmacia.repository.ClientRepository;
import com.api.farmacia.repository.StoreRepository;

@Service
public class ClientService {

	@Autowired 
	ClientRepository clientRepository;
	
	
	
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	public Client findById(Long id) {
		return clientRepository.findById(id).get(); 	
	}	
		
	public Client save(Client client) {
		return clientRepository.save(client);
	}
	
	public Client edit(Client client) {
		return clientRepository.save(client);
	}
	
	public Client delete(Long id) {
		Optional<Client> excluir = clientRepository.findById(id);
		clientRepository.delete(excluir.get());
		return excluir.get();
	}
}
