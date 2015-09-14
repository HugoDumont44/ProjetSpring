package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.model.Adresse;
import com.bankonet.model.Client;

public class Test_TP6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1 - Chargement du conteneur Spring
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
				
		// 2 - Récupération du bean métier du conteneur
		IBankonetMetier metier = (IBankonetMetier) context.getBean("metier");
		
		// 3 - Utilisation du bean
		System.out.println(metier.listClients());
		try {
			metier.addClient(new Client("toto", "tata", "log2", "mdp2", new Adresse(36, "avenue Cyrnos", "Paris")));
			metier.addClient(new Client("nom", "prenom", "log", "mdp", new Adresse(59, "rue Gronois", "Nîmes")));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(metier.listClients());
	}

}
