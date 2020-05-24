package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import filme.Film;
import filme.Filmliste;
import filme.UC_Film_erfassen;
import filme.UC_Film_suchen;
import kunden.Kundenliste;
import kunden.UC_Guthaben_aufladen;
import kunden.UC_Kunde_erfassen;
import kunden.UC_Kunde_suchen;

public class Hauptmenu_Besitzer extends JFrame {


	ActionHandler a;

	JButton filmerfassen;
	JButton kundeerfassen;
	JButton filmsuchen;
	JButton kundesuchen;
	JButton guthabenaufladen;

	GridLayout gr;

	UC_Film_erfassen ucf;
	UC_Kunde_erfassen uck;
	UC_Film_suchen ucsf;
	UC_Kunde_suchen ucks;
	UC_Guthaben_aufladen uga;

	Filmliste fl;
	Kundenliste kl;

	public Hauptmenu_Besitzer() {

		super("Hauptmenu Besitzer");

		fl = new Filmliste();

		fl.laden();

		kl = new Kundenliste();

		kl.laden();

		a = new ActionHandler();

		filmerfassen = new JButton("Film erfassen");
		kundeerfassen = new JButton("Kunde erfassen");
		filmsuchen = new JButton("Film suchen");
		kundesuchen = new JButton("Kunde suchen");
		guthabenaufladen = new JButton("Guthaben aufladen");
		
		
		filmerfassen.addActionListener(a);
		kundeerfassen.addActionListener(a);
		filmsuchen.addActionListener(a);
		kundesuchen.addActionListener(a);
		guthabenaufladen.addActionListener(a);
		
		gr = new GridLayout(2, 2);

		super.setLayout(gr);

		add(filmerfassen);
		add(kundeerfassen);
		add(filmsuchen);
		add(kundesuchen);

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
				ucsf = new UC_Film_suchen(fl);
			}
			
			if (e.getSource() == kundesuchen) {
				kl.laden();
				ucks = new UC_Kunde_suchen(kl);
			}
		}
	}

	public static void main(String[] args) {
		Hauptmenu_Besitzer hb = new Hauptmenu_Besitzer();

		hb.setVisible(true);
		hb.setSize(400, 400);
		hb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
