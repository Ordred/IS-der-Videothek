package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

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

	private hmButtons filmerfassen;
	private hmButtons kundeerfassen;
	private hmButtons filmsuchen;
	private hmButtons kundesuchen;
	private hmButtons guthabenaufladen;
	private hmButtons mediumsuchen;
	private hmButtons mediumerfassen;

	private GridLayout gr;

	private UC_Film_erfassen ucf;
	private UC_Kunde_erfassen uck;
	private UC_Film_suchen ucsf;
	private UC_Kunde_suchen ucks;
	private UC_Guthaben_aufladen uga;
	private UC_Medium_suchen ucms;
	private UC_Medium_erfassen ucme;

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

		filmerfassen = new hmButtons("Film erfassen");
		kundeerfassen = new hmButtons("Kunde erfassen");
		filmsuchen = new hmButtons("Film suchen");
		kundesuchen = new hmButtons("Kunde suchen");
		guthabenaufladen = new hmButtons("Guthaben aufladen");
		mediumsuchen = new hmButtons("Medium suchen");
		mediumerfassen = new hmButtons("Medium erfassen");


		filmerfassen.addActionListener(a);
		kundeerfassen.addActionListener(a);
		filmsuchen.addActionListener(a);
		kundesuchen.addActionListener(a);
		guthabenaufladen.addActionListener(a);
		mediumsuchen.addActionListener(a);
		mediumerfassen.addActionListener(a);

		gr = new GridLayout(3, 3);

		super.setLayout(gr);

		add(filmerfassen);
		add(kundeerfassen);
		add(filmsuchen);
		add(kundesuchen);
		add(mediumsuchen);
		add(mediumerfassen);

	}

	public class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == filmerfassen) {
				fl.laden();
				ucf = new UC_Film_erfassen(fl);
				fl.laden();
			}

			if (e.getSource() == kundeerfassen) {
				kl.laden();
				uck = new UC_Kunde_erfassen(kl);
				kl.laden();
			}

			if (e.getSource() == filmsuchen) {
				fl.laden();
				ml.laden();
				ucsf = new UC_Film_suchen(fl, false, kl, ml, k);
			}

			if (e.getSource() == kundesuchen) {
				kl.laden();
				ucks = new UC_Kunde_suchen(kl, false);
			}

			if (e.getSource() == mediumsuchen) {

				ml.laden();
				ucms = new UC_Medium_suchen(ml, kl);
			}

			if (e.getSource() == mediumerfassen) {
				ml.laden();
				fl.laden();
				ucme = new UC_Medium_erfassen(ml, fl);
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
