package com.bankonet.spring;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bankonet.model.Client;

public class SaveValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return Client.class.equals(clazz);
	}

	@Override
	public void validate(Object client, Errors e) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "nom", "Un nom doit �tre r�dig�");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "prenom", "Un pr�nom doit �tre r�dig�");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "login", "Un login doit �tre r�dig�");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "motDePasse", "Un mot de passe doit �tre r�dig�");
		
		Client c = (Client) client;
		// Nom
		if (c.getNom().length() < 3 && c.getNom().isEmpty() == false) {
			e.rejectValue("nom", "valeurfaible", "Le nom doit �tre sup�rieur � 3");
		} else if (c.getNom().length() > 60 && c.getNom().isEmpty() == false) {
			e.rejectValue("nom", "valeurforte", "Le nom doit �tre inf�rieur � 60");
		}

		// Pr�nom
		if (c.getPrenom().length() < 3) {
			e.rejectValue("prenom", "valeurfaible", " Le prenom doit �tre sup�rieur � 3");
		} else if (c.getPrenom().length() > 60) {
			e.rejectValue("prenom", "valeurforte", " Le prenom doit �tre inf�rieur � 60");
		}
		
		// Login
		if (c.getLogin().length() < 2) {
			e.rejectValue("login", "valeurfaible", " Le login doit �tre sup�rieur � 2");
		} else if (c.getLogin().length() > 16) {
			e.rejectValue("login", "valeurforte", " Le login doit �tre inf�rieur � 16");
		}
		
		// Mot de passe
		if (c.getMotDePasse().length() < 6) {
			e.rejectValue("motDePasse", "valeurfaible", " Le mot de passe doit �tre sup�rieur � 6");
		} else if (c.getMotDePasse().length() > 50) {
			e.rejectValue("motDePasse", "valeurforte", " Le mot de passe doit �tre inf�rieur � 50");
		}
	}


}
