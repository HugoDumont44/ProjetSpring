package com.bankonet.model;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Adresse {

	//Attributs
	private int numero;
	
	private String rue;
	
	private String ville;
	
	
	//Constructeur
	public Adresse() {
	}
	public Adresse(int numero, String rue, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
	}

	//Getters
	public int getNumero() {
		return numero;
	}
	public String getRue() {
		return rue;
	}

	public String getVille() {
		return ville;
	}

	//Setters
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	//Méthodes
	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", rue=" + rue + ", ville="
				+ ville + "]";
	}
	
}
