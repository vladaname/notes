package com.example.notes.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the osoba database table.
 * 
 */
@Entity
@NamedQuery(name="Osoba.findAll", query="SELECT o FROM Osoba o")
public class Osoba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_osoba")
	private int idOsoba;
	private String email;
	private String ime;
	private String pass;
	private String prezime;
	private String username;

	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="osoba")
	private List<Note> notes;

	public Osoba() {
	}


	public int getIdOsoba() {
		return idOsoba;
	}



	public void setIdOsoba(int idOsoba) {
		this.idOsoba = idOsoba;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getIme() {
		return ime;
	}



	public void setIme(String ime) {
		this.ime = ime;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public String getPrezime() {
		return prezime;
	}



	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public List<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Note addNote(Note note) {
		getNotes().add(note);
		note.setOsoba(this);

		return note;
	}

	public Note removeNote(Note note) {
		getNotes().remove(note);
		note.setOsoba(null);

		return note;
	}

}