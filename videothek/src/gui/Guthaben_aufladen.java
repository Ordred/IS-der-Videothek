package gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;

import javax.swing.JTextField;

import controller.UC_Guthaben_aufladen;
import gui_elemente.Buttons;
import gui_elemente.ErfassLabel;
import gui_elemente.ErfassPanel;

public class Guthaben_aufladen extends JFrame {
	
	private ErfassLabel betrag;
	private JTextField eingabe;
	private Buttons abbrechen;
	private Buttons speichern;
	
	private ErfassPanel buttons;
	private ErfassPanel eingeben;
	
	private UC_Guthaben_aufladen uga;
	
	private ActionHandler a;

	public Guthaben_aufladen(UC_Guthaben_aufladen uga) {
		
		super("Guthaben aufladen");
		
		
		
		this.uga = uga;
		
		a = new ActionHandler();
		
		betrag = new ErfassLabel("Betrag");
		eingabe= new JTextField("Betrag eingeben");
		abbrechen = new Buttons("Abbrechen");
		speichern = new Buttons("Speichern");
		
		abbrechen.addActionListener(a);
		speichern.addActionListener(a);
		
		buttons = new ErfassPanel();
		eingeben = new ErfassPanel();
		
		buttons.setLayout(new FlowLayout());
		eingeben.setLayout(new FlowLayout());
		
		buttons.add(abbrechen);
		buttons.add(speichern);
		
		eingeben.add(betrag);
		eingeben.add(eingabe);
		
		super.setLayout(new GridLayout(1, 2));
		
		add(eingeben);
		add(buttons);
		
	}
	
	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
			if (e.getSource() == abbrechen) {
				dispose();
			}
			
			if (e.getSource() == speichern) {
				
				uga.aufladen(Integer.parseInt(eingabe.getText()));
				
				dispose();
				
			}
			
		}
		
		
	}
	
	
	
	
	
}
