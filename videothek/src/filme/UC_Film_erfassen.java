package filme;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JFrame;

import gui.Film_Erfassen;

public class UC_Film_erfassen {

	private Film f;
	private Filmliste fl;
	Film_Erfassen fe;

	public UC_Film_erfassen (Filmliste fl) {
		f = new Film();
		fe = new Film_Erfassen(this);
		fe.setVisible(true);
		fe.setSize(400, 400);
		fe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.fl = fl;
	}
	
	

	public void setJahr(int jahr) {

		f.setJahr(jahr);

	}

	public void setHülle(Icon hülle) {

		f.setHülle(hülle);

	}
	public void setGenre(String genre) {

		f.setGenre(genre);

	}
	public void setTitel(String titel) {

		f.setTitel(titel);

	}
	public void setBeschreibung(String beschreibung) {

		f.setBeschreibung(beschreibung);

	}
	
	public void speichern() {

		fl.filmHinzufügen(f);
	}
}
