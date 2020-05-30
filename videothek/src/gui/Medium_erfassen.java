package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JComboBox;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.UC_Medium_erfassen;
import model.Medienliste;

public class Medium_erfassen extends SuchFrame{
	
	private ErfassLabel mediumL;
	private JComboBox<String> medium;
	
	private String [] mArten = {"Blu-Ray","DVD","VHS"};
	private ErfassLabel preisL;
	private JTextField preis;

	private Buttons filmerfassen;
	
	private Buttons speichern;
	private Buttons abbrechen;
	
	private ErfassPanel buttons;
	private ErfassPanel preise;
	private ErfassPanel medien;
	
	private ActionHandler a;
	
	private UC_Medium_erfassen ume;
	private Medienliste ml;
	
	
	public Medium_erfassen(UC_Medium_erfassen ume, Medienliste ml) {
		super("Medium erfassen");
		
		setLocationRelativeTo(null);
		
		this.ume = ume;		
		this.ml = ml;
		
		
		
		
		a = new ActionHandler();
		buttons = new ErfassPanel(new FlowLayout());
		medien = new ErfassPanel(new FlowLayout());
		preise = new ErfassPanel(new FlowLayout());
		
		
		
		
		
		
		
		mediumL = new ErfassLabel("Medium", SwingConstants.LEFT);
		medium = new JComboBox<String>(mArten);
		
		preisL = new ErfassLabel("Preis", SwingConstants.LEFT);
		preis = new JTextField("Hier Preis eingeben");
		
		filmerfassen = new Buttons("Film hinzufügen");
		
		speichern = new Buttons("Speichern");
		abbrechen = new Buttons("Abbrechen");
		
		filmerfassen.addActionListener(a);
		speichern.addActionListener(a);
		abbrechen.addActionListener(a);
		
		medien.add(mediumL, BorderLayout.WEST);
		medien.add(medium, BorderLayout.CENTER);
		
		preise.add(preisL, BorderLayout.WEST);
		preise.add(preis, BorderLayout.CENTER);
		
		buttons.add(filmerfassen);
		buttons.add(speichern);
		buttons.add(abbrechen);
		
		
		setLayout(new GridLayout(3, 1));
		
		add(medien);
		add(preise);
		add(buttons);
		
		
		
		
		
	}
	
	
	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == filmerfassen) {
				ume.setFilm();
			}
			
			if (e.getSource() == speichern) {
				
				ume.setMedium(medium.getSelectedItem().toString());
				ume.setPreis(Integer.parseInt(preis.getText()));
				ume.speichern();
				dispose();
			}
			
			if (e.getSource() == abbrechen) {
				dispose();
			}
			
		}
		
	}
	
	

}
