package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.buttons;
import javax.swing.JFrame;
import javax.swing.erfassLabel;
import javax.swing.erfassPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.UC_Film_bearbeiten;
import controller.UC_Film_erfassen;
import gui_elemente.Buttons;
import gui_elemente.ErfassFrame;
import gui_elemente.ErfassLabel;
import gui_elemente.ErfassPanel;
import gui_elemente.L�schDialog;

public class Film_Bearbeiten extends ErfassFrame{

	/* JFilechooser */
	
	private UC_Film_bearbeiten ucfb;
	
	private JTextField titel;
	private JTextField jahr;
	private JTextField genre;
	private JTextField beschreibung;
	
	private ErfassLabel titelL;
	private ErfassLabel jahrL;
	private ErfassLabel genreL;
	private ErfassLabel beschreibungL;
	
	private ErfassPanel buttons;
	private ErfassPanel form;
	
	private GridLayout gl1;
	
	private FlowLayout fl;
	
	private Buttons speichern;
	private Buttons abbrechen;
	private Buttons l�schen;
	private Buttons bildw�hlen;
	
	private Buttons ja;
	private Buttons nein;
	
	private ActionHandler a;
	private JFileChooser datei;
	private String icS;
	
	private JDialog zahl;
	private Buttons ok;
	
	private L�schDialog l�schen2;	
	
	public Film_Bearbeiten(UC_Film_bearbeiten ucfb) {
		
		super("Film bearbeiten");
		
		
				
	
		this.ucfb = ucfb;
		
		ok = new Buttons("Ok");
		
		
		
		a = new ActionHandler();
		
		form = new ErfassPanel(null);
		buttons = new ErfassPanel(null);
		
		gl1 = new GridLayout(4,2);
		fl = new FlowLayout();
		
		form.setLayout(gl1);
		buttons.setLayout(fl);
		
		speichern = new Buttons("Speichern");
		abbrechen = new Buttons("Abbrechen");
		l�schen = new Buttons("L�schen");
		bildw�hlen = new Buttons("Bild ausw�hlen");
		
		ja = new Buttons("Ja");
		nein = new Buttons("Nein");
		
		titel = new JTextField(ucfb.getF().getTitel());
		jahr = new JTextField(ucfb.getF().getJahr());
		genre = new JTextField(ucfb.getF().getGenre());
		beschreibung = new JTextField(ucfb.getF().getBeschreibung());
		icS = ucfb.getF().getH�lle();
		
		titelL = new ErfassLabel("Titel", SwingConstants.CENTER);
		jahrL = new ErfassLabel("Jahr", SwingConstants.CENTER);
		genreL = new ErfassLabel("Genre", SwingConstants.CENTER);
		beschreibungL = new ErfassLabel("Beschreibung", SwingConstants.CENTER);
		
		titel.addActionListener(a);
		jahr.addActionListener(a);
		genre.addActionListener(a);
		beschreibung.addActionListener(a);
		bildw�hlen.addActionListener(a);
		
		speichern.addActionListener(a);
		abbrechen.addActionListener(a);
		l�schen.addActionListener(a);
		
		ja.addActionListener(a);
		nein.addActionListener(a);
		
		ok.addActionListener(a);
		
		form.add(titelL);
		form.add(titel);
		form.add(jahrL);
		form.add(jahr);
		form.add(genreL);
		form.add(genre);
		form.add(beschreibungL);
		form.add(beschreibung);
		
		
		buttons.add(abbrechen);
		buttons.add(bildw�hlen);
		buttons.add(l�schen);
		buttons.add(speichern);
		
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
			
			if (e.getSource() == nein) {
				l�schen2.dispose();
			}
			
			if (e.getSource() == ja) {
				ucfb.l�schen();
			}
			
			if (e.getSource() == bildw�hlen) {
				datei = new JFileChooser();
				datei.setName("Bild w�hlen");
				
				int result = datei.showOpenDialog(new JDialog());
				
				if (result == JFileChooser.APPROVE_OPTION) {
				    icS = datei.getSelectedFile().getName();
				}
				

				    
				datei.setVisible(true);
				datei.setSize(300, 300);
			}
			
			if (e.getSource() == ok) {
				zahl.dispose();
			}
			
			if (e.getSource() == speichern) {
				
				try {
				
				ucfb.setTitel(titel.getText());
				ucfb.setGenre(genre.getText());
				ucfb.setJahr(Integer.parseInt(jahr.getText()));
				ucfb.setBeschreibung(beschreibung.getText());
				ucfb.setH�lle(icS);
				ucfb.speichern();

				dispose();
				} catch (NumberFormatException exception) {
					zahl = new JDialog();
					zahl.setTitle("Bitte Zahl bei Jahr eingeben");
					zahl.setVisible(true);
					zahl.add(new ErfassLabel("Bitte Zahl bei Jahr eingeben!", SwingConstants.CENTER), BorderLayout.CENTER);
					zahl.add(ok,SwingConstants.SOUTH);
					zahl.setSize(300, 150);
					zahl.setLocationRelativeTo(null);
					zahl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} 
			}
			
			if (e.getSource() == l�schen) {
				
				ErfassPanel ll = new ErfassPanel(new FlowLayout());
				l�schen2 = new L�schDialog("Film l�schen", "Sind Sie sicher, dass Sie diesen Film l�schen m�chten? "
						+ "Damit gehen alle damit verbundenen Medien verloren.", SwingConstants.CENTER);
				l�schen2.setLocationRelativeTo(null);
				ll.add(ja);
				ll.add(nein);
				l�schen2.add(ll, BorderLayout.CENTER);
				l�schen2.setVisible(true);
				
				
			}
			
		}
		
	}

}
