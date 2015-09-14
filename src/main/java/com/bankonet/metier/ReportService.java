package com.bankonet.metier;

import com.bankonet.report.IReportGenerator;

public class ReportService {
	
	// Attributs
	private IReportGenerator report;
	private String auteur;
	
	// Constructeur
	public ReportService(IReportGenerator report) {
		this.report = report;
	}

	// Getter
	public IReportGenerator getReport() {
		return report;
	}

	public String getAuteur() {
		return auteur;
	}

	// Setter
	public void setReport(IReportGenerator report) {
		this.report = report;
	}
	
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	/*METHODES DE COMPORTEMENT*/
		public void generateAnnualReport() {
			report.generate(getAuteur());
		}
		
		public void generateMonthlyReport() {
			report.generate(getAuteur());
		}
		
		public void generateDailyReport() {
			report.generate(getAuteur());
		}
}
