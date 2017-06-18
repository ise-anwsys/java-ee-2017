package de.tub.as.smm.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Nutzer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	// You can also add attribute specific annotations 
	// directly to the attribute instead of the getter,
	// but mixing them does not work!
	private Long id;
	private String vorname;
	private String nachname;
	private String email;
	
	private Set<Angebot> angebote;
	
	public Nutzer() {
		
	}
	
	public Nutzer(String vorname, String nachname, String email) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return vorname + " " + nachname;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public String getEmail() {
		return email;
	}

	// The Collection indicates that Angebot is the many side of the relationship.
	// One Nutzer has Many Angebot(e)
	@OneToMany(mappedBy="anbieter")
	public Set<Angebot> getAngebote() {
		return angebote;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAngebote(Set<Angebot> angebote) {
		this.angebote = angebote;
	}
	
	
}
