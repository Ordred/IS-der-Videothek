package controller;

import javax.swing.JFrame;

import gui.Film_suchen;
import gui.Medium_erfassen;
import model.Film;
import model.Filmliste;
import model.Kunde;
import model.Kundenliste;
import model.Medienliste;
import model.Medium;

public class UC_Medium_erfassen {

	private Medium m;
	private Medienliste ml;
	private Film_suchen fs;
	private Filmliste fl;
	private Film f;
	private Medium_erfassen me;
	private Kundenliste kl;

	public UC_Medium_erfassen(Medienliste ml, Filmliste fl) {
		m = new Medium();
		this.ml = ml;
		this.fl = fl;

		me = new Medium_erfassen(null, this, ml);
		me.setVisible(true);
		me.setSize(400, 220);
		me.setLocationRelativeTo(null);
		me.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


	}


	public Film_suchen getFs() {
		return fs;
	}


	public void setFs(Film_suchen fs) {
		this.fs = fs;
	}


	public Medium_erfassen getMe() {
		return me;
	}


	public void setMe(Medium_erfassen me) {
		this.me = me;
	}


	public void setID(int id) {
		m.setId(id);
	}

	public void setPreis(int preis) {
		m.setPreis(-preis);
	}

	public void setFilm() {
		fs = new Film_suchen(new UC_Film_suchen(false, fl, true, kl, ml, null), true, null, true, this, fl, kl, ml);
		fs.setVisible(true);
		fs.setSize(300, 240);
		fs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public void setFilm2(Film f) {
		m.setFilm(f);

	}

	public void setMedium(String medium) {
		m.setMedium(medium);
	}

	public void speichern() {


		if (m.getId() == null) {
			int id = 0;
			
			for (int i = 0; i < ml.getMedienliste().size(); i++) {
				if (Integer.parseInt(ml.getMedienliste().get(i).getId()) >= id)
				{
				id = Integer.parseInt(ml.getMedienliste().get(i).getId())+1;
				}
			}
			
			m.setId(id);
			}
		ml.mediumHinzuf�gen(m);

	}

}
