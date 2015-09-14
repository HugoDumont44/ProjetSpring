package com.bankonet.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.model.Adresse;
import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;

public class Test_Compte2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1 - Chargement du conteneur Spring
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
				
		// 2 - Récupération du bean métier du conteneur
		IBankonetMetier metier = (IBankonetMetier) context.getBean("metier");
		
		// 3 - Utilisation du bean
		Client c = new Client("toto", "parain", "log2", "mdp2222222", new Adresse(36, "avenue Cyrnos", "Paris"));
		Compte epargne = new CompteEpargne(3, "Compte epargne *3", 0, 0, 1500);
		Compte courant = new CompteCourant(1, "Compte courant", 0, 100);
		
		metier.addClient(c);
		metier.addCompte(epargne);
		metier.addCompte(courant);
		
		List<Compte> listing = new ArrayList<Compte>();
		listing.add(epargne);
		listing.add(courant);
		
		metier.ajoutComptes(listing);
		
		System.out.println(metier.listClients());
	}

}
