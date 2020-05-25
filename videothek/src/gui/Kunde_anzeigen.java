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

import kunden.Kunde;
import kunden.Kundenliste;
import kunden.UC_Guthaben_aufladen;

public class Kunde_anzeigen extends JFrame {
	
	private Kunde k;
	private Kundenliste kl;
	
	private UC_Guthaben_aufladen uga;
	
	private ActionHandler a;
	
	private Kunde_anzeigen ka;
	
	private GridLayout gl;
	private FlowLayout fl;
	
	private JPanel angaben;
	private JPanel buttons;
	
	private JLabel name;
	private JLabel vorname;
	private JLabel geburtsdatum;
	private JLabel lieblingsgenre;
	private JLabel guthaben;
	
	private JLabel nameT;
	private JLabel vornameT;
	private JLabel geburtsdatumT;
	private JLabel lieblingsgenreT;
	private JLabel guthabenT;
	
	private JButton guthabenaufladen;
	private JButton abbrechen;
	
	public Kunde_anzeigen(Kunde k, Kundenliste kl) {
		super("Kundeinformationen");
		
		a = new ActionHandler();
		
		this.k = k;
		this.kl = kl;
		ka = this;
		
		angaben = new JPanel();
		buttons = new JPanel();
		
		name = new JLabel("Name");
		vorname = new JLabel("Vorname");
		geburtsdatum = new JLabel("Geburtsdatum");
		lieblingsgenre = new JLabel("Lieblingsgenre");
		guthaben = new JLabel("Guthaben");
		
		nameT = new JLabel(k.getName());
		vornameT = new JLabel(k.getVorname());
		geburtsdatumT = new JLabel(k.getGeburtsdatum());
		lieblingsgenreT = new JLabel(k.getLieblingsgenre());
		guthabenT = new JLabel(Integer.toString(k.getGuthaben()));
		
		
		gl = new GridLayout(5, 2);
		fl = new FlowLayout();
		
		angaben.setLayout(gl);
		buttons.setLayout(fl);
		
		abbrechen = new JButton("Abbrechen");
		guthabenaufladen = new JButton("Guthaben aufladen");
		
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
			}
			
			
		}
		
	}

}
