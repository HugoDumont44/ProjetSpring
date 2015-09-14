package com.bankonet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@DiscriminatorValue("C")
public class Client extends Personne {

	//Attributs
	@NotNull
	@Size(max=16,min=2)
	private String login;
	
	@NotNull
	@Size(max=50,min=6)
	private String motDePasse;
	
	@Embedded
	private Adresse adresse;
	
	@OneToMany
	private List<Compte> comptes;
	
	
	//Constructeurs	
	public Client() {
		comptes = new ArrayList<Compte>();
	}
	public Client(String nom, String prenom) {
		super(nom, prenom);
	}
	public Client(String nom, String prenom, Adresse adresse) {
		super(nom, prenom);
		this.adresse = adresse;
	}
	public Client(String nom, String prenom, String log, String mdp, Adresse adresse) {
		super(nom, prenom);
		this.adresse = adresse;
		this.login = log;
		this.motDePasse = mdp;
	}
	
	//Getters
	public Adresse getAdresse() {
		return adresse;
	}
	
	public String getLogin() {
		return login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}
	
	public List<Compte> getComptes() {
		return comptes;
	}
	
	//Setters
	@Autowired
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	public void setComptes(List comptes) {
		this.comptes = comptes;
	}
	
	//Méthodes
	@Override
	public String toString() {
		return "Client [id=" + this.getId() + ", nom=" + this.getNom() + ", prenom=" + this.getPrenom()
				+ ", adresse=" + adresse + "]";
	}
	
}
