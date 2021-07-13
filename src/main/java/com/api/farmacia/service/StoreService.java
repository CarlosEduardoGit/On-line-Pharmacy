package com.api.farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.farmacia.model.Store;
import com.api.farmacia.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired 
	private StoreRepository storeRepository;
	
	
	
	public List<Store> findAll() {
		return storeRepository.findAll();
	}
	
	public Store findById(Long id) {
		return storeRepository.findById(id).get(); 
	}	
		
	public Store save(Store store) {
		return storeRepository.save(store);
	}
	
	public Store edit(Store store) {
		return storeRepository.save(store);
	}
	
	public Store delete(Long id) {
		Optional<Store> excluir = storeRepository.findById(id);
		storeRepository.delete(excluir.get());
		return excluir.get();
	}
		
}
