package com.api.farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.farmacia.model.Product;
import com.api.farmacia.model.Stock;
import com.api.farmacia.model.Store;
import com.api.farmacia.repository.ProductRepository;
import com.api.farmacia.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired 
	StockRepository stockRepository;
	
	
	
	public List<Stock> findAll() {
		return stockRepository.findAll();
	}
	
	public Stock findById(Long id) {
		return stockRepository.findById(id).get(); 	
	}	
		
	public Stock save(Stock stock) {
		return stockRepository.save(stock);
	}
	
	public Stock edit(Stock stock) {
		return stockRepository.save(stock);
	}
	
	public Stock delete(Long id) {
		Optional<Stock> excluir = stockRepository.findById(id);
		stockRepository.delete(excluir.get());
		return excluir.get();
	}
		
}
