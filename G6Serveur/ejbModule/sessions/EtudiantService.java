package sessions;

import java.util.List;

import dao.EtudiantDao;
import dao.IDao;
import entities.Employe;
import entities.Etudiant;
import entities.Filiere;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless(name = "G4EtuS")
public class EtudiantService implements EtudiantDao<Etudiant> {
	

	@PersistenceContext
	private EntityManager em;

	@Override
	@PermitAll
	public Etudiant create(Etudiant o) {
		em.persist(o);
		return o;
	}

	@Override
	@PermitAll
	public Etudiant delete(Etudiant o) {
	    if (o != null && o.getCNE() != null) {  
	        em.remove(em.contains(o) ? o : em.merge(o));
	    }
	    return o;
		
	}
	@PermitAll
	@Override
	public Etudiant update(Etudiant o) {
		if (o != null && o.getCNE()!= null) { 
	        Etudiant existingEtudiant = em.find(Etudiant.class, o.getId());
	        if (existingEtudiant != null) {
	            existingEtudiant.setNom(o.getNom());
	            existingEtudiant.setPrenom(o.getPrenom());
	            existingEtudiant.setCNE(o.getCNE());
	            em.merge(existingEtudiant);
	            return existingEtudiant;
	        }
	    }
	    return null;
	}

	@Override
	public Etudiant findById(String cne) {
	    if (cne != null) {
	        return em.find(Etudiant.class, cne);
	    } else {
	        return null;
	    }
	}

	@Override
	@PermitAll
	public List<Etudiant> findAll() {
		Query query = em.createQuery("select e from Etudiant e");
		return query.getResultList();
	}

	@Override
	@PermitAll
	public void AffecterFiliere(int etudiantId, int filiereId) {
		Etudiant etudiant = em.find(Etudiant.class, etudiantId);
		Filiere filiere = em.find(Filiere.class, filiereId);

		if (etudiant != null && filiere != null) {
			etudiant.setFiliere(filiere);

			em.merge(etudiant);
		}
	}
	@Override
	@PermitAll
    public List<Etudiant> getEtudiantsByFiliere(Filiere filiere) {
        if (filiere != null) {
            String jpql = "SELECT e FROM Etudiant e WHERE e.filiere = :filiere";
            return em.createQuery(jpql, Etudiant.class)
                .setParameter("filiere", filiere)
                .getResultList();
        } else {
            return null;
        }
    }
}
