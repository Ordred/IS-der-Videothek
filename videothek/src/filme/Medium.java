package filme;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Medium implements Serializable {

	private String medium;
	private int id;
	private Film film;
	private boolean lagernd;
	private LocalDate rückgabedatum;

	public Medium(String medium, int id, Film film) {

		this.medium = medium;
		this.id = id;
		this.film = film;
		lagernd = true;

	}

	public boolean isLagernd() {
		return lagernd;
	}

	public void setLagernd(boolean lagernd) {
		this.lagernd = lagernd;
	}

	public LocalDate getRückgabedatum() {
		return rückgabedatum;
	}

	public void setRückgabedatum(LocalDate rückgabedatum) {
		this.rückgabedatum = rückgabedatum;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

}
