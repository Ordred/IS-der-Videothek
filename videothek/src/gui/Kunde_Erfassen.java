package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kunden.UC_Kunde_erfassen;

public class Kunde_Erfassen extends JFrame{
	
	UC_Kunde_erfassen uke;
	
	JTextField name;
	JTextField vorname;
	JTextField geburtsdatum;
	JTextField lieblingsgenre;
	JTextField guthaben;
	
	JLabel nameL;
	JLabel vornameL;
	JLabel geburtsdatumL;
	JLabel lieblingsgenreL;
	JLabel guthabenL;
	
	JPanel buttons;
	JPanel form;
	
	GridLayout gl1;
	GridLayout gl2;
	GridLayout gl3;
	
	FlowLayout fl;
	
	JButton speichern;
	JButton abbrechen;
	
	ActionHandler a;
	
	
	public Kunde_Erfassen(UC_Kunde_erfassen uke) {
		
		super("Kunde erfassen");
		
		this.uke = uke;
		
		a = new ActionHandler();
		
		gl1 = new GridLayout(5,2);
		fl = new FlowLayout();
		
		form = new JPanel(gl1);
		buttons = new JPanel(fl);
		
		speichern = new JButton("Speichern");
		abbrechen = new JButton("Abbrechen");
		
		
		name = new JTextField("Name");
		vorname = new JTextField("Vorname");
		geburtsdatum = new JTextField("Geburtsdatum");
		lieblingsgenre = new JTextField("Lieblingsgenre");
		guthaben = new JTextField("Guthaben");
		
		nameL = new JLabel("Name");
		vornameL = new JLabel("Vorname");
		geburtsdatumL = new JLabel("Geburtsdatum");
		lieblingsgenreL = new JLabel("Lieblingsgenre");
		guthabenL = new JLabel("Guthaben");
		
		name.addActionListener(a);
		vorname.addActionListener(a);
		geburtsdatum.addActionListener(a);
		lieblingsgenre.addActionListener(a);
		guthaben.addActionListener(a);
		
		speichern.addActionListener(a);
		abbrechen.addActionListener(a);

		form.add(nameL);
		form.add(name);
		form.add(vornameL);
		form.add(vorname);
		form.add(geburtsdatumL);
		form.add(geburtsdatum);
		form.add(lieblingsgenreL);
		form.add(lieblingsgenre);
		form.add(guthabenL);
		form.add(guthaben);
		
		buttons.add(abbrechen, BorderLayout.WEST);
		buttons.add(speichern, BorderLayout.EAST);
		
		add(form, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);

	}
	
	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == abbrechen) {
				dispose();
			}
			
			if (e.getSource() == speichern) {
				
				uke.setName(name.getText());
				uke.setVorname(vorname.getText());
				uke.setGeburtsdatum(geburtsdatum.getText());
				uke.setLieblingsgenre(lieblingsgenre.getText());
				uke.setGuthaben(Integer.parseInt(guthaben.getText()));
				uke.speichern();
				dispose();
			}
			
		}
		
	}

}
