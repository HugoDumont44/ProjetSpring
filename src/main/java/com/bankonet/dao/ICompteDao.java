package com.bankonet.dao;

import java.util.List;

import com.bankonet.model.Compte;

public interface ICompteDao {

	public void addCompte(Compte c);
	public List<Compte> listComptes();
	public void deleteCompte(int idCompte);
	public Compte editCompte(int idCompte);
	public void updateCompte(Compte c);
}
