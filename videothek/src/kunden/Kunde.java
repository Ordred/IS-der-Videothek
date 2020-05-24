package kunden;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.Icon;

import filme.Medium;

public class Kunde implements Serializable {
	
	private String name;
	private String vorname;
	private String geburtsdatum;
	private String lieblingsgenre;
	private int guthaben;
	private ArrayList<Medium> ausleihliste;
	
	
	public void ausleihen(Medium medium) {
		if (ausleihliste == null) {
			ausleihliste = new ArrayList<Medium>();
		}
		ausleihliste.add(medium);
	}
	
	public ArrayList<Medium> getAusleihliste() {
		return ausleihliste;
	}
	public void setAusleihliste(ArrayList<Medium> ausleihliste) {
		this.ausleihliste = ausleihliste;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	public String getLieblingsgenre() {
		return lieblingsgenre;
	}
	public void setLieblingsgenre(String lieblingsgenre) {
		this.lieblingsgenre = lieblingsgenre;
	}
	public int getGuthaben() {
		return guthaben;
	}
	public void setGuthaben(int guthaben) {
		this.guthaben = guthaben;
	}
	
}
