package sessions;

import java.util.List;

import dao.IDao;
import dao.IdaoLocal;
import entities.Employe;
import entities.Etudiant;
import entities.Filiere;

import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless (name = "G4FiliereS")
public class FiliereService implements IDao<Filiere> {
	
	@PersistenceContext 
	private EntityManager em;

	@Override
	@PermitAll
	public Filiere create(Filiere o) {
		em.persist(o);
		return o;
	}

	@Override
	public Filiere delete(Filiere o) {
	    if (o != null && o.getId() != 0) {  
	        em.remove(em.contains(o) ? o : em.merge(o));
	    }
	    return o;
	}

	@Override
	public Filiere update(Filiere o) {
		if (o != null && o.getId()!= 0) { 
	        Filiere existingEtudiant = em.find(Filiere.class, o.getId());
	        if (existingEtudiant != null) {
	            existingEtudiant.setCode(o.getCode());
	            existingEtudiant.setName(o.getName());
	            em.merge(existingEtudiant);
	            return existingEtudiant;
	        }
	    }
		return null;
	}

	@Override
	public Filiere findById(int id) {
		if (id != 0) {
	        return em.find(Filiere.class, id);
	    } else {
	        return null;
	    }
	}

	@Override
	@PermitAll
	public List<Filiere> findAll() {
		Query query = em.createQuery("select e from Role e");
		return query.getResultList();
	}

}
