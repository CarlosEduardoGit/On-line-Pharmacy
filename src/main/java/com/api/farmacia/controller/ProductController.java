package com.api.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.api.farmacia.model.Product;

import com.api.farmacia.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	
	@GetMapping
	public ModelAndView Product() {
		ModelAndView mv = new ModelAndView("products");
		List<Product> products = productService.findAll();
		mv.addObject( "products", products );
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView ProductById(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("productById");
		Product product = productService.findById(id);
		mv.addObject( "product", product );
		return mv;
	}
	
	@GetMapping("/create")
	public ModelAndView ProductForm() {
		ModelAndView mv = new ModelAndView("productForm");
		return mv;
	}
	
	@PostMapping("/create")
	public ModelAndView SaveProduct(@Validated Product product, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			ModelAndView mv = new ModelAndView("productForm");
			return mv;
		}

		productService.save(product);
		ModelAndView mv = new ModelAndView("products");
		List<Product> products = productService.findAll();
		mv.addObject( "products", products );
		return mv;
		
	}
}
