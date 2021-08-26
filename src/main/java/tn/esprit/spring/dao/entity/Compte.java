package tn.esprit.spring.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "T_COMPTE")
public class Compte implements Serializable{
	
/**
	 * 
	 */
	
	//	---------startId-------------
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private int id;
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
//	---------startId-------------
	
	
//	---------startNumCompte-------------
	@Column(name="NumCompte")
	private int numCompte;
	
	public int getNumCompte(){
		return numCompte;
	}
	public void setNumCompte(int numComte){
		this.numCompte = numCompte;
	}
//	---------endNumCompte-------------
	
//	---------startSolde-------------
	@Column(name="Solde")
	private double solde;
	
	public double getSole(){
		return solde;
	}
	public void setSolde(double solde){
		this.solde = solde;
	}
//	---------startDate-------------
	@Temporal (TemporalType.DATE)
	private Date dateCreation;
	
	public Date getDate(){
		return dateCreation;
	}
	public void setId(Date dateCreation){
		this.dateCreation = dateCreation;
	}
	
}
