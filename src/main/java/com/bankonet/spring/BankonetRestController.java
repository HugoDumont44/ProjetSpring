package com.bankonet.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.model.Client;

@Controller
@RequestMapping(value="/BankonetSpringMVC/rest")
public class BankonetRestController {

	@Autowired
	private IBankonetMetier metier;

	@RequestMapping(value="/", method = RequestMethod.GET)
	@ResponseBody
	public List<Client> getAll() {
		return metier.listClients();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Client> get(@PathVariable("id") String motCle) {
		return metier.chercherClients(motCle);
	}

	@RequestMapping(value="/saveClient", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestBody Client entity) {
		metier.addClient(entity);
	}
	
	@RequestMapping(value="/editClient", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Client entity) {
		metier.updateClient(entity);
	}

	@RequestMapping(value = "/deleteClient/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") int id) {
		metier.deleteClient(id);
	}

}
