package filme;

import java.io.Serializable;

import javax.swing.Icon;

public class Film implements Serializable {
	
	private String titel;
	private int jahr;
	private Icon h�lle;
	private String beschreibung;
	private String genre;
	
	
	
	public Icon getH�lle() {
		return h�lle;
	}
	public void setH�lle(Icon h�lle) {
		this.h�lle = h�lle;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public int getJahr() {
		return jahr;
	}
	public void setJahr(int jahr) {
		this.jahr = jahr;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	

}
