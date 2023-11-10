package sessions;

import java.util.List;

import dao.IDao;
import dao.IdaoLocal;
import entities.Employe;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless (name = "G4EmpS")
public class EmployeService implements IDao<Employe> ,IdaoLocal<Employe>{
	
	@PersistenceContext 
	private EntityManager em;

	@Override
	@PermitAll
	public Employe create(Employe o) {
		em.persist(o);
		return o;
	}

	@Override
	public Employe delete(Employe o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employe update(Employe o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employe findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@PermitAll
	public List<Employe> findAll() {
		Query query = em.createQuery("select e from Employe e");
		List<Employe> employees= query.getResultList();
		System.out.print(employees);
		return employees;
	}

}
