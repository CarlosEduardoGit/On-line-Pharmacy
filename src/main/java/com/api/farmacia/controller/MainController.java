package com.api.farmacia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.api.farmacia.model.Store;
import com.api.farmacia.service.ClientService;
import com.api.farmacia.service.ProductService;
import com.api.farmacia.service.StockService;
import com.api.farmacia.service.StoreService;
@RestController
@RequestMapping("/painel")
public class MainController {
	
	@GetMapping
	public ModelAndView MainPainel() {
		ModelAndView mv = new ModelAndView("painel");
		return mv;
	}
}
