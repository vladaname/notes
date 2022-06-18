package com.example.notes.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the notes database table.
 * 
 */
@Entity
@Table(name="notes")
@NamedQuery(name="Note.findAll", query="SELECT n FROM Note n")
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_Notes;

	private String opis;

	//bi-directional many-to-one association to Osoba
	@ManyToOne
	@JsonIgnore
	private Osoba osoba;

	public Note() {
	}

	public int getId_Notes() {
		return this.id_Notes;
	}

	public void setId_Notes(int id_Notes) {
		this.id_Notes = id_Notes;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

}