package de.tub.as.smm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.tub.as.smm.models.Nutzer;

@Stateless
public class NutzerDao {


	@PersistenceContext
	private EntityManager em;

	// no constructor implies an empty, public, no-argument constructor

	public void persist(Nutzer u) {
		em.persist(u);
	}

	public List<Nutzer> getAllUsers() {
		TypedQuery<Nutzer> query = em.createQuery("SELECT u FROM User u ORDER BY u.id", Nutzer.class);
		return query.getResultList();
	}

	/**
	 * Use the parameter technique instead of direct string concatenation to avoid SQL injections
	 */
	public Nutzer getUser(long id) {
		Nutzer result = em.createQuery("SELECT u FROM User u WHERE u.id == :id", Nutzer.class)
			.setParameter("id", id)
			.getSingleResult();
		return result;
	}
}