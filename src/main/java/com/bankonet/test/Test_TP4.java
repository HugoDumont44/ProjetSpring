package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.ReportService;
import com.bankonet.model.Client;

public class Test_TP4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1 - Chargement du conteneur Spring
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
				
		// 2 - Récupération du bean client du conteneur
		Client client = (Client) context.getBean("client");
		
		// 3 - Utilisation du bean
		System.out.println(client.toString());
	}

}
