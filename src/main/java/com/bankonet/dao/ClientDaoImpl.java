package com.bankonet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;

@Repository("clientDao")
public class ClientDaoImpl implements IClientDao {

	//Attribut
	@PersistenceContext
	private EntityManager em;
	
	//Getter/setter
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}

	/*Méthodes*/
	@Transactional(propagation=Propagation.MANDATORY)
	public void addClient(Client c) {
		// TODO Auto-generated method stub
		System.out.println("dans ClientDaoImpl.addClient --> client ajouté !");
		em.persist(c);
	}

	@Transactional(readOnly=true, propagation=Propagation.MANDATORY)
	public List<Client> listClients() {
		// TODO Auto-generated method stub
		System.out.println("dans ClientDaoImpl.listClients --> liste des clients !");
		Query req = em. createQuery("SELECT c FROM Client c");
		return req.getResultList();
	}

	@Transactional(propagation=Propagation.MANDATORY)
	public void deleteClient(int idClient) {
		// TODO Auto-generated method stub
		System.out.println("dans ClientDaoImpl.deleteClient --> suppression du client !");
		Client c=em.find(Client.class, idClient);
		em.remove(c);
	}

	@Transactional(propagation=Propagation.MANDATORY)
	public Client editClient(int idClient) {
		// TODO Auto-generated method stub
		System.out.println("dans ClientDaoImpl.editClient --> client édité !");
		Client c=em.find(Client.class, idClient);
		return c;
	}

	@Transactional(propagation=Propagation.MANDATORY)
	public void updateClient(Client c) {
		// TODO Auto-generated method stub
		System.out.println("dans ClientDaoImpl.updateClient --> client modifié !");
		em.merge(c);
	}

	@Transactional(propagation=Propagation.MANDATORY)
	public List<Client> chercherClients(String motCle) {
		// TODO Auto-generated method stub
		System.out.println("dans ClientDaoImpl.chercherClients --> client trouvé !");
		Query req = em.createQuery("SELECT c FROM Client c WHERE c.nom LIKE :x OR c.prenom LIKE :x");
		req.setParameter("x", "%"+motCle+"%");
		return req.getResultList();
	}
	
	@Transactional(propagation=Propagation.MANDATORY)
	public void ajoutComptes(List<Compte> liste) {
		em.persist(liste);
	}

}
