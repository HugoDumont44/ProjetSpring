package com.bankonet.dao;

import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;

public interface IClientDao {

	public void addClient(Client c);
	public List<Client> listClients();
	public void deleteClient(int idClient);
	public Client editClient(int idClient);
	public void updateClient(Client c);
	public List<Client> chercherClients(String motCle);
	
	public void ajoutComptes(List<Compte> liste);
}
