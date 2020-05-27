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

import controller.UC_Guthaben_aufladen;

public class Guthaben_aufladen extends JFrame {
	
	private JLabel betrag;
	private JTextField eingabe;
	private JButton abbrechen;
	private JButton speichern;
	
	private JPanel buttons;
	private JPanel eingeben;
	
	private UC_Guthaben_aufladen uga;
	
	private ActionHandler a;

	public Guthaben_aufladen(UC_Guthaben_aufladen uga) {
		
		super("Guthaben aufladen");
		
		
		setLocationRelativeTo(null);
		this.uga = uga;
		
		a = new ActionHandler();
		
		betrag = new JLabel("Betrag");
		eingabe= new JTextField("Betrag eingeben");
		abbrechen = new JButton("Abbrechen");
		speichern = new JButton("Speichern");
		
		abbrechen.addActionListener(a);
		speichern.addActionListener(a);
		
		buttons = new JPanel();
		eingeben = new JPanel();
		
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
