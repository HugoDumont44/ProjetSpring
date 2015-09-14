package com.bankonet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Compte {

	// Attributs
	@Id
	@GeneratedValue
	private int id;
	private String libelle;
	private float solde;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	// Constructeur
	public Compte(int id, String libelle, float solde) {
		this.id = id;
		this.libelle = libelle;
		this.solde = solde;
	}
	public Compte(){
		
	}

	// Getters
	public int getId() {
		return id;
	}
	public String getLibelle() {
		return libelle;
	}
	public float getSolde() {
		return solde;
	}

	public Client getClient() {
		return client;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}

	public void setClient(Client client) {
		System.out.println("Client ajouté !");
		this.client = client;
	}
	
}
