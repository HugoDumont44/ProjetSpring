package com.bankonet.metier;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.*;

import com.bankonet.dao.IClientDao;
import com.bankonet.dao.ICompteDao;
import com.bankonet.model.Client;
import com.bankonet.model.Compte;

@Service("bankonetMetier")
public class BankonetMetierImpl implements IBankonetMetier {

	// Attributs
	@Resource(name="clientDao")
	private IClientDao clientDao;
	
	@Resource(name="compteDao")
	private ICompteDao compteDao;
	
	// Getters/setters
	public IClientDao getClientDao() {
		return clientDao;
	}
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}
	public ICompteDao getCompteDao() {
		return compteDao;
	}
	public void setCompteDao(ICompteDao compteDao) {
		this.compteDao = compteDao;
	}
	
	
	/*Méthodes métier client*/
	@Transactional
	public void addClient(Client c) {
		clientDao.addClient(c);
	}

	@Transactional(readOnly=true)
	public List<Client> listClients() {
		// TODO Auto-generated method stub
		return clientDao.listClients();
	}

	@Transactional
	public void deleteClient(int idClient) {
		// TODO Auto-generated method stub
		clientDao.deleteClient(idClient);
	}

	@Transactional
	public Client editClient(int idClient) {
		// TODO Auto-generated method stub
		return clientDao.editClient(idClient);
	}

	@Transactional
	public void updateClient(Client c) {
		// TODO Auto-generated method stub
		clientDao.updateClient(c);
	}

	@Transactional(readOnly=true)
	public List<Client> chercherClients(String motCle) {
		// TODO Auto-generated method stub
		return clientDao.chercherClients(motCle);
	}
	
	@Transactional(readOnly=true)
	public List<Client> SupprimerClientDontLeNomContient(String motCle) {
		for(Client c : clientDao.chercherClients(motCle)){
			clientDao.deleteClient(c.getId());
		}
		return clientDao.listClients();
	}
	
	@Transactional
	public void ajoutComptes(List<Compte> liste) {
		clientDao.ajoutComptes(liste);
	}
	
	
	/*Méthodes métier compte*/
	@Transactional
	public void addCompte(Compte c) {
		compteDao.addCompte(c);
	}

	@Transactional(readOnly=true)
	public List<Compte> listComptes() {
		// TODO Auto-generated method stub
		return compteDao.listComptes();
	}

	@Transactional
	public void deleteCompte(int idCompte) {
		// TODO Auto-generated method stub
		compteDao.deleteCompte(idCompte);
	}

	@Transactional
	public Compte editCompte(int idCompte) {
		// TODO Auto-generated method stub
		return compteDao.editCompte(idCompte);
	}

	@Transactional
	public void updateCompte(Compte c) {
		// TODO Auto-generated method stub
		compteDao.updateCompte(c);
	}

}
