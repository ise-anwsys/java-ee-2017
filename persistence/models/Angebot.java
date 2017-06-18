package de.tub.as.smm.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity annotation is necessary so the System can find your class
 */
@Entity
public class Angebot implements Serializable { // Persistence entities need to be serializable
	private static final long serialVersionUID = 1L;

	// You can also add attribute specific annotations 
	// directly to the attribute instead of the getter,
	// but mixing them does not work!
	private Long id;
	private String name;
	private double preis;
	private Date erstellDatum;

	// Reference to the other model class
	// Don't forget your relationship annotations!
	private Nutzer anbieter;

	public Angebot() {

	}

	public Angebot(String name) {
		this.name = name;
		this.erstellDatum = new Date(System.currentTimeMillis());
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPreis() {
		return preis;
	}

	public Date getErstellDatum() {
		return erstellDatum;
	}

	// Don't forget mappedBy in the class that does not own the relationship (here: Angebot)!
	// In a OneToMany relationship that is always the many side!
	@ManyToOne
	public Nutzer getAnbieter() {
		return anbieter;
	}

	public void setErstellDatum(Date erstellDatum) {
		this.erstellDatum = erstellDatum;
	}

	public void setAnbieter(Nutzer anbieter) {
		this.anbieter = anbieter;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	@Override
	public String toString() {
		return "Angebot [id=" + id + ", name=" + name + ", preis=" + preis + "]";
	}

}