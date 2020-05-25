package filme;

import javax.swing.JFrame;

import gui.Film_suchen;
import gui.Medium_erfassen;

public class UC_Medium_erfassen {
	
	private Medium m;
	private Medienliste ml;
	private Film_suchen fs;
	private Filmliste fl;
	private Film f;
	private Medium_erfassen me;
	
	public UC_Medium_erfassen(Medienliste ml, Filmliste fl) {
		m = new Medium();
		this.ml = ml;
		this.fl = fl;
		
		me = new Medium_erfassen(this, ml);
		me.setVisible(true);
		me.setSize(300, 200);
		me.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}
	
	
	public void setID(int id) {
		m.setId(id);
	}
	
	public void setFilm() {
		fs = new Film_suchen(new UC_Film_suchen(fl, true), true);
		fs.setVisible(true);
		fs.setSize(300, 200);
		fs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f = fs.getF();
		m.setFilm(f);
	}
	
	public void setMedium(String medium) {
		m.setMedium(medium);
	}
	
	public void speichern() {
		
		ml.mediumHinzufügen(m);
		
	}

}
