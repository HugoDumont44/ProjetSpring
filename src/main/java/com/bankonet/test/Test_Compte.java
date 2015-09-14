package com.bankonet.test;

import java.util.ArrayList;
import java.util.List;

import com.bankonet.model.Adresse;
import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;

public class Test_Compte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Client c = new Client("toto", "tata", "log2", "mdp2", new Adresse(36, "avenue Cyrnos", "Paris"));
		Compte epargne = new CompteEpargne(3, "Compte epargne *3", 0, 0, 1500);
		Compte courant = new CompteCourant(1, "Compte courant", 0, 100);
		
		epargne.setClient(c);
		courant.setClient(c);
		
		List<Compte> listing = new ArrayList<Compte>();
		listing.add(epargne);
		listing.add(courant);
		c.setComptes(listing);
		
		System.out.println(c.getComptes().toString());
	}

}
