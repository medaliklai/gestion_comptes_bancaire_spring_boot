package tn.esprit.spring.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entity.Compte;

import tn.esprit.spring.dao.repository.compteRepository;
@Service
public class CompteImpl implements CompteService{

	@Autowired
	 compteRepository CompteRepository;
	

	@Override
	public List<Compte> retrieveAllComptes() {
		List<Compte> comptes = (List<Compte>) CompteRepository.findAll();
		return comptes;
	}
	public void deleteCompte(int id)
	{
		CompteRepository.deleteById(id);
	}
	@Override
	public Compte consulterCompteById(int id) {
		Compte c = CompteRepository.findById(id).get();
		return c;
	}
	@Override
	public List<Compte> chercherNumCompte(int numCompte) {
		List<Compte> c = CompteRepository.cherche(numCompte);
		return c;
	}

	public void verser(int numCompte, double montant) {
		Compte compteOne = CompteRepository.findByNumCompte(numCompte);
		double newSolde1 = compteOne.getSole() + montant;
		CompteRepository.modifierSolde(newSolde1, numCompte);
		
	}

	@Override
	public void retirer(int numCompte, double montant) {
		Compte compteOne = CompteRepository.findByNumCompte(numCompte);
		double newSolde1 = compteOne.getSole() - montant;
		CompteRepository.modifierSolde(newSolde1, numCompte);
		
	}

	
//	public void virement(int numCompte1, int numCompte2, double montant) {
//		Compte compteOne = CompteRepository.findByNumCompte(numCompte1);
//		double newSolde1 = compteOne.getSole() - montant;
//		CompteRepository.modifierSolde(newSolde1, numCompte1);
//		
//		Compte compteTwo = CompteRepository.findByNumCompte(numCompte2);
//		double newSolde2 = compteTwo.getSole() - montant;
//		CompteRepository.modifierSolde(newSolde2, numCompte2);
//		
//		
//		
//	}



//	@Override
//	public void verser(int numComte, double montant) {
//		// TODO Auto-generated method stub
//		
//	}

}
