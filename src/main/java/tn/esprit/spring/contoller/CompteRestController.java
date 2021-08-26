package tn.esprit.spring.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dao.entity.Compte;
import tn.esprit.spring.service.CompteService;



@RestController
public class CompteRestController {
	
	@Autowired
	CompteService compteService;
	
	@CrossOrigin()
	@GetMapping("/All")
	 @ResponseBody
	 public List<Compte> getComptes() {

     List<Compte> list = compteService.retrieveAllComptes();
     return list;
	}
	
	@CrossOrigin()
	@GetMapping("/one-compte/{compte-id}")
	 @ResponseBody
	 public Compte getCompte(@PathVariable("compte-id") int id) {

     Compte c = compteService.consulterCompteById(id);
     return c;
	}
	
	
	@CrossOrigin()
	@DeleteMapping("/remove-compte{id}")
	@ResponseBody
	public void removeCompte(@PathVariable("id") int id){
		compteService.deleteCompte(id);
	}
	
	@CrossOrigin()
	@GetMapping("/chercher-par-compte{numC}")
	@ResponseBody
	public List<Compte> chercherCompte(@PathVariable("numC") int numC){
		List<Compte> c = compteService.chercherNumCompte(numC);
		return c;
	}
	
	@CrossOrigin()
	@PostMapping("/retrieve/{numC}/{mantant}")
	@ResponseBody		
	public void retieveSolde(@PathVariable("numC") int numC, @PathVariable("mantant") double montant){
		compteService.retirer(numC, montant);
		
	}
	
	@CrossOrigin()
	@PostMapping("/verser/{numC}/{mantant}")
	@ResponseBody
	public void veserSolde(@PathVariable("numC") int numC, @PathVariable("mantant") double montant){
		compteService.verser(numC, montant);
		
	}
	
	@CrossOrigin()
	@GetMapping("/virement/{numC1}/{numC2}/{mantant}")
	@ResponseBody
	public boolean virement(@PathVariable("numC1") int numC1,@PathVariable("numC2") int numC2, @PathVariable("mantant") double montant){
		compteService.retirer(numC1, montant);
		compteService.verser(numC2, montant);
		return true;
		
	}
	

}
