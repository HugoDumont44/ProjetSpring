package com.bankonet.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.model.Client;

@Controller
@RequestMapping(value="/BankonetSpringMVC/compte")
public class BankonetComptesController {

	@Autowired
	private IBankonetMetier metier;
	
	@RequestMapping(value="/")
	public String index (Model model){
		
		return "comptesview";
	}
}
