package gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JComboBox;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.UC_Medium_erfassen;
import model.Medienliste;

public class Medium_erfassen extends erfassFrame{
	
	private erfassLabel mediumL;
	private JComboBox<String> medium;
	
	private String [] mArten = {"Blu-Ray","DVD","VHS"};
	private erfassLabel preisL;
	private JTextField preis;

	private buttons filmerfassen;
	
	private buttons speichern;
	private buttons abbrechen;
	
	private erfassPanel buttons;
	private erfassPanel preise;
	private erfassPanel medien;
	
	private ActionHandler a;
	
	private UC_Medium_erfassen ume;
	private Medienliste ml;
	
	
	public Medium_erfassen(UC_Medium_erfassen ume, Medienliste ml) {
		super("Medium erfassen");
		
		setLocationRelativeTo(null);
		
		this.ume = ume;		
		this.ml = ml;
		
		
		
		
		a = new ActionHandler();
		buttons = new erfassPanel(null);
		medien = new erfassPanel(null);
		preise = new erfassPanel(null);
		
		buttons.setLayout(new FlowLayout());
		medien.setLayout(new FlowLayout());
		preise = new erfassPanel(new FlowLayout());
		
		
		ume.setID(ml.getMedienliste().size());
		
		mediumL = new erfassLabel("Medium", SwingConstants.LEFT);
		medium = new JComboBox<String>(mArten);
		
		preisL = new erfassLabel("Preis", SwingConstants.CENTER);
		preis = new JTextField("Hier Preis eingeben");
		
		filmerfassen = new buttons("Film hinzufügen");
		
		speichern = new buttons("Speichern");
		abbrechen = new buttons("Abbrechen");
		
		filmerfassen.addActionListener(a);
		speichern.addActionListener(a);
		abbrechen.addActionListener(a);
		
		medien.add(mediumL);
		medien.add(medium);
		
		preise.add(preisL);
		preise.add(preis);
		
		buttons.add(filmerfassen);
		buttons.add(speichern);
		buttons.add(abbrechen);
		
		
		super.setLayout(new GridLayout(3, 1));
		
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
