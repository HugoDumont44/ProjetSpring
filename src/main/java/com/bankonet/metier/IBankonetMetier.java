package com.bankonet.metier;

import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;

public interface IBankonetMetier {

	public void addClient(Client c);
	public List<Client> listClients();
	public void deleteClient(int idClient);
	public Client editClient(int idClient);
	public void updateClient(Client c);
	public List<Client> chercherClients(String motCle);
	
	public void ajoutComptes(List<Compte> liste);
	
	public void addCompte(Compte c);
	public List<Compte> listComptes();
	public void deleteCompte(int idCompte);
	public Compte editCompte(int idCompte);
	public void updateCompte(Compte c);
}
