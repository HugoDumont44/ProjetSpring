package com.bankonet.report;

public class HtmlReportGenerator extends ReportGenerator implements IReportGenerator {

	public void generate() {
		// TODO Auto-generated method stub
		System.out.println("Génération d'un rapport HTML...");
	}

	public void generate(String auteur) {
		// TODO Auto-generated method stub
		this.generate();
		System.out.println("-> Auteur : "+auteur);
	}

}
