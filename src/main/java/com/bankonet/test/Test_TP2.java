package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.ReportService;
import com.bankonet.report.ReportFactory;
import com.bankonet.report.ReportGenerator;

public class Test_TP2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1 - Chargement du conteneur Spring
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
				
		// 2 - Récupération de 2 beans du conteneur
		ReportService reportService1 = (ReportService) context.getBean("reportService");
		ReportService reportService2 = (ReportService) context.getBean("reportService");
		
		// 3 - Déclaration de 2 auteurs
		reportService1.setAuteur("auteur1");
		reportService2.setAuteur("auteur2");
		
		// 4 - Utilisation du bean
		reportService1.generateAnnualReport();
		reportService2.generateDailyReport();
	}

}
