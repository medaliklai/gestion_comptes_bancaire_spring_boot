package tn.esprit.spring.service;



import java.util.List;

import tn.esprit.spring.dao.entity.Compte;


public interface CompteService {
	public List<Compte> retrieveAllComptes();
	public Compte consulterCompteById(int id);
	public void deleteCompte(int id);
    public List<Compte> chercherNumCompte(int numCompte);
	public void verser(int  numComte, double montant);
	public void retirer(int numComte, double montant);


	

}
