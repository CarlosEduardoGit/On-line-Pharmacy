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

import com.api.farmacia.model.Stock;
import com.api.farmacia.model.Store;
import com.api.farmacia.service.StockService;

@RestController
@RequestMapping("/stocks")
public class StockController {

	@Autowired
	private StockService stockService;
	
	
	
	@GetMapping
	public ModelAndView Stock() {
		ModelAndView mv = new ModelAndView("stocks");
		List<Stock> stocks = stockService.findAll();
		mv.addObject( "stocks", stocks );
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView StockById(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("stockById");
		Stock stock = stockService.findById(id);
		mv.addObject( "stock", stock );
		return mv;
	}
	
	@GetMapping("/create")
	public ModelAndView StockForm() {
		ModelAndView mv = new ModelAndView("stockForm");
		return mv;
	}
	
	@PostMapping("/create")
	public ModelAndView SaveStock(@Validated Stock stock, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			ModelAndView mv = new ModelAndView("stockForm");
			return mv;
		}

		stockService.save(stock);
		ModelAndView mv = new ModelAndView("stocks");
		List<Stock> stocks = stockService.findAll();
		mv.addObject( "stocks", stocks );
		return mv;
		
	}
	
}
