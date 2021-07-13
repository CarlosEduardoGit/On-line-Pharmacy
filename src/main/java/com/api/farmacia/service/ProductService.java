package com.api.farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.farmacia.model.Product;
import com.api.farmacia.model.Stock;
import com.api.farmacia.model.Store;
import com.api.farmacia.repository.ProductRepository;
import com.api.farmacia.repository.StoreRepository;

@Service
public class ProductService {
	
	@Autowired 
	ProductRepository productRepository;
	
	
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		return productRepository.findById(id).get(); 
	}	
		
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public Product edit(Product product) {
		return productRepository.save(product);
	}
	
	public Product delete(Long id) {
		Optional<Product> excluir = productRepository.findById(id);
		productRepository.delete(excluir.get());
		return excluir.get();
	}
}
