package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.dao.IClientDao;

public class Test_TP5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1 - Chargement du conteneur Spring
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
				
		// 2 - Récupération du bean métier du conteneur
		IClientDao metier = (IClientDao) context.getBean("bankonetMetier");
		
		// 3 - Utilisation du bean
		metier.listClients();
	}

}
