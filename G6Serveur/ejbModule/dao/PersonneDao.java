package dao;

import java.util.List;

import entities.Etudiant;
import entities.Filiere;
import jakarta.ejb.Remote;




@Remote
public interface PersonneDao <T> {
	T create(T o);
	T delete(T o);
	T update(T o);
	T findById(int id);
	List<T> findAll();
	void AffecterRole(int et ,int f);

}
