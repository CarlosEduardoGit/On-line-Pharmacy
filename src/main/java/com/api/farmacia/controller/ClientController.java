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

import com.api.farmacia.model.Client;
import com.api.farmacia.service.ClientService;
import com.api.farmacia.service.ProductService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	
	
	@GetMapping
	public ModelAndView Client() {
		ModelAndView mv = new ModelAndView("clients");
		List<Client> clients = clientService.findAll();
		mv.addObject( "clients", clients );
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView ClientById(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("clientById");
		Client client = clientService.findById(id);
		mv.addObject( "client", client );
		return mv;
	}
	
	@GetMapping("/create")
	public ModelAndView ClientForm() {
		ModelAndView mv = new ModelAndView("clientForm");
		return mv;
	}
	
	@PostMapping("/create")
	public ModelAndView SaveClient(@Validated Client client, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			ModelAndView mv = new ModelAndView("clientForm");
			return mv;
		}

		clientService.save(client);
		ModelAndView mv = new ModelAndView("clients");
		List<Client> clients = clientService.findAll();
		mv.addObject( "clients", clients );
		return mv;
	}

}
