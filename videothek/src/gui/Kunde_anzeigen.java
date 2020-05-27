package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


import controller.UC_Guthaben_aufladen;
import model.Kunde;
import model.Kundenliste;

public class Kunde_anzeigen extends JFrame {
	
	private Kunde k;
	private Kundenliste kl;
	
	private UC_Guthaben_aufladen uga;
	
	private ActionHandler a;
	
	private Kunde_anzeigen ka;
	
	private GridLayout gl;
	private FlowLayout fl;
	
	private erfassPanel angaben;
	private erfassPanel buttons;
	
	private erfassLabel name;
	private erfassLabel vorname;
	private erfassLabel geburtsdatum;
	private erfassLabel lieblingsgenre;
	private erfassLabel guthaben;
	
	private erfassLabel nameT;
	private erfassLabel vornameT;
	private erfassLabel geburtsdatumT;
	private erfassLabel lieblingsgenreT;
	private erfassLabel guthabenT;
	
	private buttons guthabenaufladen;
	private buttons abbrechen;
	
	public Kunde_anzeigen(Kunde k, Kundenliste kl) {
		super("Kundeninformationen");
		
		setLocationRelativeTo(null);
		
		setLocationRelativeTo(null);
		a = new ActionHandler();
		
		this.k = k;
		this.kl = kl;
		ka = this;
		
		angaben = new erfassPanel();
		buttons = new erfassPanel();
		
		name = new erfassLabel("Name");
		vorname = new erfassLabel("Vorname");
		geburtsdatum = new erfassLabel("Geburtsdatum");
		lieblingsgenre = new erfassLabel("Lieblingsgenre");
		guthaben = new erfassLabel("Guthaben");
		
		nameT = new erfassLabel(k.getName());
		vornameT = new erfassLabel(k.getVorname());
		geburtsdatumT = new erfassLabel(k.getGeburtsdatum());
		lieblingsgenreT = new erfassLabel(k.getLieblingsgenre());
		guthabenT = new erfassLabel(Integer.toString(k.getGuthaben()));
		
		
		gl = new GridLayout(5, 2);
		fl = new FlowLayout();
		
		angaben.setLayout(gl);
		buttons.setLayout(fl);
		
		abbrechen = new buttons("Abbrechen");
		guthabenaufladen = new buttons("Guthaben aufladen");
		
		abbrechen.addActionListener(a);
		guthabenaufladen.addActionListener(a);
		
		angaben.add(name);
		angaben.add(nameT);
		angaben.add(vorname);
		angaben.add(vornameT);
		angaben.add(geburtsdatum);
		angaben.add(geburtsdatumT);
		angaben.add(lieblingsgenre);
		angaben.add(lieblingsgenreT);
		angaben.add(guthaben);
		angaben.add(guthabenT);
		
		buttons.add(abbrechen);
		buttons.add(guthabenaufladen);
		
		add(angaben, BorderLayout.NORTH);
		add(buttons, BorderLayout.SOUTH);
		
		
		
	}
	
	
	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == abbrechen) {
				dispose();
			}
			
			if (e.getSource() == guthabenaufladen) {
				uga = new UC_Guthaben_aufladen(k, kl, ka);
				validate();
				repaint();
			}
			
			
		}
		
	}

}
