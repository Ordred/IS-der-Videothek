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

public class Film_Bearbeiten extends erfassFrame{

	/* JFilechooser */
	
	private UC_Film_bearbeiten ucfb;
	
	private JTextField titel;
	private JTextField jahr;
	private JTextField genre;
	private JTextField beschreibung;
	
	private erfassLabel titelL;
	private erfassLabel jahrL;
	private erfassLabel genreL;
	private erfassLabel beschreibungL;
	
	private erfassPanel buttons;
	private erfassPanel form;
	
	private GridLayout gl1;
	
	private FlowLayout fl;
	
	private buttons speichern;
	private buttons abbrechen;
	private buttons l�schen;
	private buttons bildw�hlen;
	
	private buttons ja;
	private buttons nein;
	
	private ActionHandler a;
	private JFileChooser datei;
	private String icS;
	
	private JDialog zahl;
	private buttons ok;
	
	private JDialog l�schen2;	
	
	public Film_Bearbeiten(UC_Film_bearbeiten ucfb) {
		
		super("Film bearbeiten");
		
		
				
	
		this.ucfb = ucfb;
		
		ok = new buttons("Ok");
		
		
		
		a = new ActionHandler();
		
		form = new erfassPanel(null);
		buttons = new erfassPanel(null);
		
		gl1 = new GridLayout(4,2);
		fl = new FlowLayout();
		
		form.setLayout(gl1);
		buttons.setLayout(fl);
		
		speichern = new buttons("Speichern");
		abbrechen = new buttons("Abbrechen");
		l�schen = new buttons("L�schen");
		bildw�hlen = new buttons("Bild ausw�hlen");
		
		ja = new buttons("Ja");
		nein = new buttons("Nein");
		
		titel = new JTextField(ucfb.getF().getTitel());
		jahr = new JTextField(ucfb.getF().getJahr());
		genre = new JTextField(ucfb.getF().getGenre());
		beschreibung = new JTextField(ucfb.getF().getBeschreibung());
		icS = ucfb.getF().getH�lle();
		
		titelL = new erfassLabel("Titel", SwingConstants.CENTER);
		jahrL = new erfassLabel("Jahr", SwingConstants.CENTER);
		genreL = new erfassLabel("Genre", SwingConstants.CENTER);
		beschreibungL = new erfassLabel("Beschreibung", SwingConstants.CENTER);
		
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
					zahl.add(new erfassLabel("Bitte Zahl bei Jahr eingeben!", SwingConstants.CENTER), BorderLayout.CENTER);
					zahl.add(ok,SwingConstants.SOUTH);
					zahl.setSize(300, 150);
					zahl.setLocationRelativeTo(null);
					zahl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} 
			}
			
			if (e.getSource() == l�schen) {
				
				erfassPanel ll = new erfassPanel(new FlowLayout());
				l�schen2 = new JDialog();
				l�schen2.setTitle("Film l�schen");
				l�schen2.setSize(300, 150);
				l�schen2.setLocationRelativeTo(null);
				l�schen2.add(new erfassLabel("Sind Sie sicher, dass Sie diesen Film l�schen m�chten? "
						+ "Damit gehen alle damit verbundenen Medien verloren.", SwingConstants.CENTER));
				ll.add(ja);
				ll.add(nein);
				l�schen2.add(ll, BorderLayout.CENTER);
				l�schen2.setVisible(true);
				
				
			}
			
		}
		
	}

}
