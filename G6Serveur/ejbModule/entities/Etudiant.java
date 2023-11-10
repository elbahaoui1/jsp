package entities;

import entities.Personne;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.lang.String;
import jakarta.persistence.*;

/**
 * Entity implementation class for Entity: Etudiant
 *
 */
@Entity

public class Etudiant extends Personne implements Serializable {

	   

	private String CNE;
	@ManyToOne
	private Filiere filiere;


	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	public Etudiant() {
		super();
	}   
	public String getCNE() {
		return this.CNE;
	}

	public void setCNE(String CNE) {
		this.CNE = CNE;
	}
	public Etudiant(String nom, String prenom, String CNE) {
		super(nom, prenom);
		this.CNE = CNE;
		// TODO Auto-generated constructor stub
	}
	public Etudiant(int id , String nom, String prenom, String CNE) {
		super(id, nom, prenom);
		this.CNE = CNE;
		// TODO Auto-generated constructor stub
	}
	public Etudiant(String cNE) {
		super();
		CNE = cNE;
	}
	
   
}
