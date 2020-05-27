package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.UC_Kunde_erfassen;

public class Kunde_Erfassen extends erfassFrame{
	
	private UC_Kunde_erfassen uke;
	
	private JTextField name;
	private JTextField vorname;
	private JTextField geburtsdatum;
	private JTextField lieblingsgenre;
	private JTextField guthaben;
	
	private erfassLabel nameL;
	private erfassLabel vornameL;
	private erfassLabel geburtsdatumL;
	private erfassLabel lieblingsgenreL;
	private erfassLabel guthabenL;
	
	private erfassPanel buttons;
	private erfassPanel form;
	
	private GridLayout gl1;

	
	private FlowLayout fl;
	
	private buttons speichern;
	private buttons abbrechen;
	
	private ActionHandler a;
	
	
	public Kunde_Erfassen(UC_Kunde_erfassen uke) {
		
		super("Kunde erfassen");
		
		
		setLocationRelativeTo(null);
		this.uke = uke;
		
		a = new ActionHandler();
		
		gl1 = new GridLayout(5,2);
		fl = new FlowLayout();
		
		form = new erfassPanel(gl1);
		buttons = new erfassPanel(fl);
		
		speichern = new buttons("Speichern");
		abbrechen = new buttons("Abbrechen");
		
		
		name = new JTextField("Name");
		vorname = new JTextField("Vorname");
		geburtsdatum = new JTextField("Geburtsdatum");
		lieblingsgenre = new JTextField("Lieblingsgenre");
		guthaben = new JTextField("Guthaben");
		
		nameL = new erfassLabel("Name", SwingConstants.LEFT);
		vornameL = new erfassLabel("Vorname", SwingConstants.LEFT);
		geburtsdatumL = new erfassLabel("Geburtsdatum", SwingConstants.LEFT);
		lieblingsgenreL = new erfassLabel("Lieblingsgenre", SwingConstants.LEFT);
		guthabenL = new erfassLabel("Guthaben", SwingConstants.LEFT);
		
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
