package com.bankonet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bankonet.model.Compte;

@Repository("compteDao")
public class CompteDaoImpl implements ICompteDao {

	// Attribut
	@PersistenceContext
	private EntityManager entity;
	
	//Getter/setter
	public EntityManager getEntity() {
		return entity;
	}
	public void setEntity(EntityManager em) {
		this.entity = em;
	}
	
	@Override
	public void addCompte(Compte c) {
		// TODO Auto-generated method stub
		entity.persist(c);
	}

	@Override
	public List<Compte> listComptes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCompte(int idCompte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compte editCompte(int idCompte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCompte(Compte c) {
		// TODO Auto-generated method stub
		
	}

}
