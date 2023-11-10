package dao;

import java.util.List;

import entities.Etudiant;
import entities.Filiere;
import jakarta.ejb.Remote;




@Remote
public interface EtudiantDao <T> {
	T create(T o);
	T delete(T o);
	T update(T o);
	T findById(String cne);
	List<T> findAll();
	void AffecterFiliere(int et ,int f);
	List<Etudiant> getEtudiantsByFiliere(Filiere filiere);
}
