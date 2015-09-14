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
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "nom", "Un nom doit être rédigé");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "prenom", "Un prénom doit être rédigé");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "login", "Un login doit être rédigé");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "motDePasse", "Un mot de passe doit être rédigé");
		
		Client c = (Client) client;
		// Nom
		if (c.getNom().length() < 3 && c.getNom().isEmpty() == false) {
			e.rejectValue("nom", "valeurfaible", "Le nom doit être supérieur à 3");
		} else if (c.getNom().length() > 60 && c.getNom().isEmpty() == false) {
			e.rejectValue("nom", "valeurforte", "Le nom doit être inférieur à 60");
		}

		// Prénom
		if (c.getPrenom().length() < 3) {
			e.rejectValue("prenom", "valeurfaible", " Le prenom doit être supérieur à 3");
		} else if (c.getPrenom().length() > 60) {
			e.rejectValue("prenom", "valeurforte", " Le prenom doit être inférieur à 60");
		}
		
		// Login
		if (c.getLogin().length() < 2) {
			e.rejectValue("login", "valeurfaible", " Le login doit être supérieur à 2");
		} else if (c.getLogin().length() > 16) {
			e.rejectValue("login", "valeurforte", " Le login doit être inférieur à 16");
		}
		
		// Mot de passe
		if (c.getMotDePasse().length() < 6) {
			e.rejectValue("motDePasse", "valeurfaible", " Le mot de passe doit être supérieur à 6");
		} else if (c.getMotDePasse().length() > 50) {
			e.rejectValue("motDePasse", "valeurforte", " Le mot de passe doit être inférieur à 50");
		}
	}


}
