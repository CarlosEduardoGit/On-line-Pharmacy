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

import com.api.farmacia.model.Store;
import com.api.farmacia.service.StoreService;

@RestController
@RequestMapping("/stores")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	
	
	@GetMapping
	public ModelAndView Stores() {
		ModelAndView mv = new ModelAndView("stores");
		List<Store> stores = storeService.findAll();
		mv.addObject( "stores", stores );
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView StoreById(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("storeById");
		Store store = storeService.findById(id);
		mv.addObject( "store", store );
		return mv;
	}
	
	@GetMapping("/create")
	public ModelAndView StoreForm() {
		ModelAndView mv = new ModelAndView("storeForm");
		return mv;
	}
	
	@PostMapping("/create")
	public ModelAndView SaveStore(@Validated Store store, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			
			ModelAndView mv = new ModelAndView("storeForm");
			return mv;
		}

		storeService.save(store);
		ModelAndView mv = new ModelAndView("stores");
		List<Store> stores = storeService.findAll();
		mv.addObject( "stores", stores );
		return mv;
		
	}
	
}
