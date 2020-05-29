package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import controller.UC_Film_erfassen;
import controller.UC_Film_suchen;
import controller.UC_Film_zurückgeben;
import controller.UC_Guthaben_aufladen;
import controller.UC_Kunde_erfassen;
import controller.UC_Kunde_suchen;
import controller.UC_Medium_erfassen;
import controller.UC_Medium_suchen;
import model.Film;
import model.Filmliste;
import model.Kunde;
import model.Kundenliste;
import model.Medienliste;

public class Hauptmenu_Kunde extends JFrame {


	private	ActionHandler a;
	
	private Kunde k;

	
	private buttons filmzurückgeben;
	private buttons filmsuchen;
	
	
	private GridLayout gr;

	private UC_Film_zurückgeben ucfz;
	private UC_Film_suchen ucsf;
	

	private Filmliste fl;
	private Kundenliste kl;
	private Medienliste ml;

	public Hauptmenu_Kunde(Kunde k) {

		super("Herzlich Willkommen");
		
		this.k = k;

		fl = new Filmliste();

		fl.laden();

		kl = new Kundenliste();

		kl.laden();

		ml = new Medienliste();

		ml.laden();

		a = new ActionHandler();

		
		filmzurückgeben = new buttons("Film zurückgeben");
		filmsuchen = new buttons("Film suchen");
		


		filmzurückgeben.addActionListener(a);
		filmsuchen.addActionListener(a);
		

		gr = new GridLayout(2, 1);

		super.setLayout(gr);

	
		add(filmzurückgeben);
		add(filmsuchen);
		

	}

	public Kunde getK() {
		return k;
	}

	public void setK(Kunde k) {
		this.k = k;
	}

	public Filmliste getFl() {
		return fl;
	}

	public void setFl(Filmliste fl) {
		this.fl = fl;
	}

	public Kundenliste getKl() {
		return kl;
	}

	public void setKl(Kundenliste kl) {
		this.kl = kl;
	}

	public Medienliste getMl() {
		return ml;
	}

	public void setMl(Medienliste ml) {
		this.ml = ml;
	}

	public class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub


			if (e.getSource() == filmzurückgeben) {
				kl.laden();
				ucfz = new UC_Film_zurückgeben(ml, kl, k);
				kl.laden();
			}

			if (e.getSource() == filmsuchen) {
				fl.laden();
				ml.laden();
				ucsf = new UC_Film_suchen(null, false, fl, false, kl, ml, k);
			}

			
		}
	}

	/*
	
	public static void main(String[] args) {
		Hauptmenu_Besitzer hb = new Hauptmenu_Besitzer(null);

		hb.setVisible(true);
		hb.setSize(400, 400);
		hb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
*/
	
}
