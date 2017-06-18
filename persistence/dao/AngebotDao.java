package de.tub.as.smm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.tub.as.smm.models.Angebot;
import de.tub.as.smm.models.Nutzer;

@Stateless
public class AngebotDao {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Empty constructor is needed for the injection framework
	 */
	public AngebotDao() {
	}
	
	public void persist(Angebot a) {
		em.persist(a);
	}
	
	public List<Angebot> getAllAngebote() {
		TypedQuery<Angebot> query = em.createQuery("SELECT a FROM Angebot a ORDER BY a.id", Angebot.class);
		return query.getResultList();
	}

	/**
	 * It is necessary to link them correctly together
	 * Can also be done inside the setter, but be careful not to cause an infinite loop! 
	 */	
	public void addAngebot(Angebot angebot, Nutzer u) {
		u.getAngebote().add(angebot);
		if(angebot.getAnbieter() == null) {
			angebot.setAnbieter(u);
		}
		// don't forget to persist the new element, or else it won't be saved in the database
		persist(angebot);
	}
}
