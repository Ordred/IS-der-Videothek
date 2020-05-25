package gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import filme.Medienliste;
import filme.UC_Medium_erfassen;

public class Medium_erfassen extends JFrame{
	
	private JLabel mediumL;
	private JTextField medium;

	private JButton filmerfassen;
	
	private JButton speichern;
	private JButton abbrechen;
	
	private JPanel buttons;
	private JPanel medien;
	
	ActionHandler a;
	
	UC_Medium_erfassen ume;
	Medienliste ml;
	
	
	public Medium_erfassen(UC_Medium_erfassen ume, Medienliste ml) {
		super("Medium erfassen");
		
		this.ume = ume;		
		this.ml = ml;
		
		
		a = new ActionHandler();
		buttons = new JPanel();
		medien = new JPanel();
		
		buttons.setLayout(new FlowLayout());
		medien.setLayout(new FlowLayout());
		
		
		ume.setID(ml.getMedienliste().size());
		
		mediumL = new JLabel("Medium");
		medium = new JTextField("Medium");
		
		filmerfassen = new JButton("Film hinzufügen");
		
		speichern = new JButton("Speichern");
		abbrechen = new JButton("Abbrechen");
		
		filmerfassen.addActionListener(a);
		speichern.addActionListener(a);
		abbrechen.addActionListener(a);
		
		medien.add(mediumL);
		medien.add(medium);
		
		buttons.add(filmerfassen);
		buttons.add(speichern);
		buttons.add(abbrechen);
		
		
		super.setLayout(new GridLayout(2, 1));
		
		add(medien);
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
				ume.setMedium(medium.getText());
				ume.speichern();
				dispose();
			}
			
			if (e.getSource() == abbrechen) {
				dispose();
			}
			
		}
		
	}
	
	

}
