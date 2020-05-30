package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

import controller.UC_Film_erfassen;
import controller.UC_Film_suchen;
import controller.UC_Film_zur�ckgeben;
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

	
	private buttons filmzur�ckgeben;
	private buttons filmsuchen;
	
	
	private GridLayout gr;

	private UC_Film_zur�ckgeben ucfz;
	private UC_Film_suchen ucsf;
	

	private Filmliste fl;
	private Kundenliste kl;
	private Medienliste ml;
	private erfassLabel guthaben;
	private erfassLabel guthabenL;
	private erfassPanel guthabenP;

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
		
		guthabenP = new erfassPanel(new FlowLayout());

		
		filmzur�ckgeben = new buttons("Film zur�ckgeben");
		filmsuchen = new buttons("Film suchen");
		guthaben = new erfassLabel(Integer.toString(k.getGuthaben()));
		guthabenL = new erfassLabel("Guthaben", SwingConstants.CENTER);
		guthaben.setFont(new Font("Arial", 1, 20));
		guthabenL.setFont(new Font("Arial", 1, 20));
		
		
		guthabenP.add(guthabenL);
		guthabenP.add(guthaben);


		filmzur�ckgeben.addActionListener(a);
		filmsuchen.addActionListener(a);
		
		erfassPanel buttons = new erfassPanel();
		buttons.setLayout(new GridLayout(1, 2));
		
		buttons.add(filmsuchen);
		buttons.add(filmzur�ckgeben);
		
		add(buttons, BorderLayout.CENTER);
		add(guthabenP, BorderLayout.SOUTH);
		

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


			if (e.getSource() == filmzur�ckgeben) {
				kl = new Kundenliste();
				ml = new Medienliste();
				fl = new Filmliste();
				kl.laden();
				fl.laden();
				ml.laden();
				kl.speichern();
				ml.speichern();
				fl.speichern();
				
				for (int i = 0; i < kl.getKundenliste().size(); i++) {
					if (kl.getKundenliste().get(i).getId() == k.getId())
						k = kl.getKundenliste().get(i);
				}
				

				
				
				ucsf = null;
				ucfz = null;
				
				
				ucfz = new UC_Film_zur�ckgeben(ml, kl, k);
				
				
			}

			if (e.getSource() == filmsuchen) {
				kl = new Kundenliste();
				ml = new Medienliste();
				fl = new Filmliste();
				kl.laden();
				fl.laden();
				ml.laden();
				kl.speichern();
				ml.speichern();
				fl.speichern();
				
				for (int i = 0; i < kl.getKundenliste().size(); i++) {
					if (kl.getKundenliste().get(i).getId() == k.getId())
						k = kl.getKundenliste().get(i);
				}
				

				ucsf = null;
				ucfz = null;
				
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
