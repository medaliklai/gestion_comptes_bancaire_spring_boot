package tn.esprit.spring.dao.repository;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.dao.entity.Compte;





public interface compteRepository  extends CrudRepository<Compte,Integer>{

	@Query("SELECT c FROM Compte c WHERE c.numCompte =:numCompte")
	Compte findByNumCompte(@Param("numCompte") int numCompte);
	
	@Query("SELECT c FROM Compte c WHERE c.numCompte =:numCompte")
	List<Compte> cherche(@Param("numCompte") int numCompte);
	
	@Transactional
    @Modifying
    @Query("UPDATE Compte c SET c.solde=:newSolde where c.numCompte=:numCompte")
    public void modifierSolde(@Param("newSolde")double solde, @Param("numCompte")int numCompte);
		

}
