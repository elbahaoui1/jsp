package entities;

import entities.Personne;
import java.io.Serializable;
import jakarta.persistence.*;

/**
 * Entity implementation class for Entity: Employe
 *
 */
@Entity

public class Employe extends Personne implements Serializable {

	
	private double salaire;
	private static final long serialVersionUID = 1L;

	public Employe() {
		super();
	}   
	
	public Employe(String nom, String prenom, double salaire) {
		super(nom, prenom);
		this.salaire = salaire;
	}

	public double getSalaire() {
		return this.salaire;
	}
	
	

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
   
}
