package com.bankonet.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
@Entity
public class CompteEpargne extends Compte {

	// Attributs
	private int tauxInteret;
	private int plafond;
	
	// Constructeur
	public CompteEpargne(int id, String libelle, float solde, int tx, int p) {
		super(id, libelle, solde);
		// TODO Auto-generated constructor stub
		this.tauxInteret = tx;
		this.plafond = p;
	}
	
	public CompteEpargne(){
		super();
	}

	// Getters
	public int getTauxInteret() {
		return tauxInteret;
	}
	public int getPlafond() {
		return plafond;
	}

	// Setters
	public void setTauxInteret(int tauxInteret) {
		this.tauxInteret = tauxInteret;
	}
	public void setPlafond(int plafond) {
		this.plafond = plafond;
	}
	
	public String toString() {
		return ""+this.getLibelle()+" [solde limite : "+this.getSolde()+"; "
				+ "taux d'intérêt : "+this.getTauxInteret()+"; "
						+ "plafond : "+this.getPlafond()+"]";
	}

}
