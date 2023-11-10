package sessions;

import java.util.List;

import dao.IDao;
import dao.PersonneDao;
import entities.Employe;
import entities.Etudiant;
import entities.Filiere;
import entities.Personne;
import entities.Role;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless (name = "G4PerS")

public class PersonService  implements PersonneDao<Personne>{

	@PersistenceContext 
	private EntityManager em;

	public void AffecterRole(Personne p, Role r) {
		p.setRole(r);
		em.persist(p);
	}

	@Override
	public Personne create(Personne o) {
		// TODO Auto-generated method stub
		em.persist(o);

		return o;
	}

	@Override
	public Personne delete(Personne o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personne update(Personne o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personne findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Personne> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PermitAll
	public void AffecterRole(int Personneid, int Roleid) {
		Personne personne = em.find(Personne.class, Personneid);
		Role role = em.find(Role.class, Roleid);

		if (personne != null && role != null) {
			personne.setRole(role);

			em.merge(personne);
		}
		
	}

}
