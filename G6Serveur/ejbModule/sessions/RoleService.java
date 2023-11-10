package sessions;

import java.util.List;

import dao.IDao;
import dao.IdaoLocal;
import entities.Employe;
import entities.Role;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless (name = "G4RoleS")
public class RoleService implements IDao<Role> {
	
	@PersistenceContext 
	private EntityManager em;

	@Override
	@PermitAll
	public Role create(Role o) {
		em.persist(o);
		return o;
	}

	@Override
	public Role delete(Role o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role update(Role o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PermitAll
	public List<Role> findAll() {
		Query query = em.createQuery("select e from Role e");
		return query.getResultList();
	}

}
