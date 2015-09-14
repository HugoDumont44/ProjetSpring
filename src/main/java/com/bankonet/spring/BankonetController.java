package com.bankonet.spring;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.model.Client;

@Controller
public class BankonetController{

	@Autowired
	private IBankonetMetier metier;
	
	Validator saveValidator = new SaveValidator();

	
	@RequestMapping(value="/BankonetSpringMVC")
	public String index (Model model){
		model.addAttribute("client", new Client());
		model.addAttribute("clients",metier.listClients());
		
		return "clientsview";
	}
	
	@RequestMapping(value="/BankonetSpringMVC/saveClient", method=RequestMethod.POST)
	public String saveClient(@Valid Client c, BindingResult bindingResult, Model model){
		
		if(bindingResult.hasErrors()){
			model.addAttribute("clients", metier.listClients());
			return "clientsview";
		}
		Client c2 = metier.editClient(c.getId());
		if (c2 != null){
			metier.updateClient(c);
		}
		else {
			metier.addClient(c);
		}
		
		model.addAttribute("client", new Client());
		model.addAttribute("clients",metier.listClients());
		return "clientsview";
		
	}
	
	@RequestMapping(value="/BankonetSpringMVC/deleteClient", method=RequestMethod.GET)
	public String deleteClient(@RequestParam int id, Model model){
		metier.deleteClient(id);
		
		model.addAttribute("client", new Client());
		model.addAttribute("clients",metier.listClients());
		return "clientsview";
	}
	
	@RequestMapping(value="/BankonetSpringMVC/editClient/{id}", method=RequestMethod.GET)
	public String editClient(@PathVariable int id, Model model){
		Client c = metier.editClient(id);
		
		model.addAttribute("client", c);
		model.addAttribute("clients",metier.listClients());
		return "clientsview";
	}

}
