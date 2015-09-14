package com.bankonet.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
@Entity
public class CompteCourant extends Compte {

	// Attribut
	private int debitAutorise;
	
	// Constructeur
	public CompteCourant(int id, String libelle, float solde, int debit) {
		super(id, libelle, solde);
		// TODO Auto-generated constructor stub
		this.debitAutorise=debit;
	}
	
	public CompteCourant(){
		super();
	}

	// Getter
	public int getDebitAutorise() {
		return debitAutorise;
	}

	// Setter
	public void setDebitAutorise(int debitAutorise) {
		this.debitAutorise = debitAutorise;
	}
	
	public String toString() {
		return ""+this.getLibelle()+" [solde limite : "+this.getSolde()+"; "
				+ "debit autorisé : "+this.getDebitAutorise()+"]";
	}

}
