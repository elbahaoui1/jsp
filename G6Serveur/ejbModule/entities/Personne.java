package entities;

import java.io.Serializable;
import java.lang.String;
import jakarta.persistence.*;

/**
 * Entity implementation class for Entity: Personne
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Personne implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Role role;

	public Personne() {
		super();
	}   
	
	
	
	
	public Role getRole() {
		return role;
	}




	public void setRole(Role role) {
		this.role = role;
	}




	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public Personne(int id, String nom, String prenom) {
		super();
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
   
}
