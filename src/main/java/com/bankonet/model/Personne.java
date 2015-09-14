package com.bankonet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Personne {

	//Attributs
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Size(max=60,min=3)
	private String nom;
	
	@Size(max=60,min=3)
	private String prenom;
	
	
	//Constructeurs
	public Personne() {
	}
	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	//Getters
	public String getPrenom() {
		return prenom;
	}
	public String getNom() {
		return nom;
	}
	public int getId() {
		return id;
	}

	//Setters
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
