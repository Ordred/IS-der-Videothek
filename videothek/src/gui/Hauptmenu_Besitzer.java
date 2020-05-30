package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import controller.UC_Film_bearbeiten;
import controller.UC_Film_erfassen;
import controller.UC_Film_suchen;
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

public class Hauptmenu_Besitzer extends JFrame {


	private	ActionHandler a;
	
	private Kunde k;

	private buttons filmerfassen;
	private buttons kundeerfassen;
	private buttons filmsuchen;
	private buttons kundesuchen;
	private buttons guthabenaufladen;
	private buttons mediumsuchen;
	private buttons mediumerfassen;
	private buttons filmbearbeiten;

	private GridLayout gr;

	private UC_Film_erfassen ucf;
	private UC_Kunde_erfassen uck;
	private UC_Film_suchen ucsf;
	private UC_Kunde_suchen ucks;
	private UC_Guthaben_aufladen uga;
	private UC_Medium_suchen ucms;
	private UC_Medium_erfassen ucme;
	private UC_Film_bearbeiten ucfb;

	private Filmliste fl;
	private Kundenliste kl;
	private Medienliste ml;
	


	public Hauptmenu_Besitzer(Kunde k) {

		super("Hauptmenu Besitzer");
		
		
		setLocationRelativeTo(null);
		this.k = k;

		fl = new Filmliste();

		fl.laden();

		kl = new Kundenliste();

		kl.laden();

		ml = new Medienliste();

		ml.laden();

		a = new ActionHandler();

		filmerfassen = new buttons("Film erfassen");
		kundeerfassen = new buttons("Kunde erfassen");
		filmsuchen = new buttons("Film suchen");
		kundesuchen = new buttons("Kunde suchen");
		guthabenaufladen = new buttons("Guthaben aufladen");
		mediumsuchen = new buttons("Medium suchen");
		mediumerfassen = new buttons("Medium erfassen");
		filmbearbeiten = new buttons("Film bearbeiten");
		


		filmerfassen.addActionListener(a);
		kundeerfassen.addActionListener(a);
		filmsuchen.addActionListener(a);
		kundesuchen.addActionListener(a);
		guthabenaufladen.addActionListener(a);
		mediumsuchen.addActionListener(a);
		mediumerfassen.addActionListener(a);
		filmbearbeiten.addActionListener(a);

		gr = new GridLayout(3, 3);

		super.setLayout(gr);

		add(filmerfassen);
		add(kundeerfassen);
		add(mediumerfassen);
		add(filmsuchen);
		add(kundesuchen);
		add(mediumsuchen);		
		add(filmbearbeiten);

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

			if (e.getSource() == filmerfassen) {
				ucf = null;
				uck = null;
				ucsf = null;
				ucks = null;
				ucms = null;
				ucme = null;
				ucfb = null;
				fl.laden();
				ucf = new UC_Film_erfassen(fl);
				fl.laden();
				
			}

			if (e.getSource() == kundeerfassen) {
				ucf = null;
				uck = null;
				ucsf = null;
				ucks = null;
				ucms = null;
				ucme = null;
				ucfb = null;
				kl = new Kundenliste();
				ml = new Medienliste();
				fl = new Filmliste();
				kl.laden();
				fl.laden();
				ml.laden();
				
				uck = new UC_Kunde_erfassen(kl);
				
				
			}

			if (e.getSource() == filmsuchen) {
				ucf = null;
				uck = null;
				ucsf = null;
				ucks = null;
				ucms = null;
				ucme = null;
				ucfb = null;
				kl = new Kundenliste();
				ml = new Medienliste();
				fl = new Filmliste();
				kl.laden();
				fl.laden();
				ml.laden();
				
				ucsf = new UC_Film_suchen(null, false, fl, false, kl, ml, k);
			}

			if (e.getSource() == kundesuchen) {
				ucf = null;
				uck = null;
				ucsf = null;
				ucks = null;
				ucms = null;
				ucme = null;
				ucfb = null;
				kl = new Kundenliste();
				ml = new Medienliste();
				fl = new Filmliste();
				kl.laden();
				fl.laden();
				ml.laden();
				
				ucks = new UC_Kunde_suchen(kl, false);
			}

			if (e.getSource() == mediumsuchen) {
				ucf = null;
				uck = null;
				ucsf = null;
				ucks = null;
				ucms = null;
				ucme = null;
				ucfb = null;
				kl = new Kundenliste();
				ml = new Medienliste();
				fl = new Filmliste();
				kl.laden();
				fl.laden();
				ml.laden();
				
				ucms = new UC_Medium_suchen(ml, kl);
			}

			if (e.getSource() == mediumerfassen) {
				ucf = null;
				uck = null;
				ucsf = null;
				ucks = null;
				ucms = null;
				ucme = null;
				ucfb = null;
				kl = new Kundenliste();
				ml = new Medienliste();
				fl = new Filmliste();
				kl.laden();
				fl.laden();
				ml.laden();
				
				ucme = new UC_Medium_erfassen(ml, fl);
			}
			
			if (e.getSource() == filmbearbeiten) {
				ucf = null;
				uck = null;
				ucsf = null;
				ucks = null;
				ucms = null;
				ucme = null;
				ucfb = null;
				kl = new Kundenliste();
				ml = new Medienliste();
				fl = new Filmliste();
				kl.laden();
				fl.laden();
				ml.laden();
				ucfb = new UC_Film_bearbeiten(fl, ml, kl);
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
