package gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import filme.Medienliste;
import filme.UC_Medium_erfassen;

public class Medium_erfassen extends JFrame{
	
	private JLabel mediumL;
	private JComboBox<String> medium;
	
	private String [] mArten = {"Blu-Ray","DVD","VHS"};
	private JLabel preisL;
	private JTextField preis;

	private JButton filmerfassen;
	
	private JButton speichern;
	private JButton abbrechen;
	
	private JPanel buttons;
	private JPanel preise;
	private JPanel medien;
	
	private ActionHandler a;
	
	private UC_Medium_erfassen ume;
	private Medienliste ml;
	
	
	public Medium_erfassen(UC_Medium_erfassen ume, Medienliste ml) {
		super("Medium erfassen");
		
		this.ume = ume;		
		this.ml = ml;
		
		
		
		
		a = new ActionHandler();
		buttons = new JPanel();
		medien = new JPanel();
		preise = new JPanel();
		
		buttons.setLayout(new FlowLayout());
		medien.setLayout(new FlowLayout());
		preise = new JPanel(new FlowLayout());
		
		
		ume.setID(ml.getMedienliste().size());
		
		mediumL = new JLabel("Medium");
		medium = new JComboBox<String>(mArten);
		
		preisL = new JLabel("Preis", SwingConstants.CENTER);
		preis = new JTextField("Hier Preis eingeben");
		
		filmerfassen = new JButton("Film hinzufügen");
		
		speichern = new JButton("Speichern");
		abbrechen = new JButton("Abbrechen");
		
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
