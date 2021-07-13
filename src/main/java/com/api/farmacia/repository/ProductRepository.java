package com.api.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.api.farmacia.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
