package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.UC_Film_erfassen;

public class Film_Erfassen extends ErfassFrame{

	/* JFilechooser */
	
	private UC_Film_erfassen ufe;
	
	private JTextField titel;
	private JTextField jahr;
	private JTextField genre;
	private JTextField beschreibung;
	private Buttons h�lle;
	
	private ErfassLabel titelL;
	private ErfassLabel jahrL;
	private ErfassLabel genreL;
	private ErfassLabel beschreibungL;
	private ErfassLabel h�lleL;
	
	private ErfassPanel buttons;
	private ErfassPanel form;
	
	private GridLayout gl1;
	
	private FlowLayout fl;
	
	private Buttons speichern;
	private Buttons abbrechen;
	
	private ActionHandler a;
	
	private String dateiname;
	
	private JFileChooser datei;
	
	private Buttons ok;
	
	private JDialog zahl;
	

	

	
	
	public Film_Erfassen(UC_Film_erfassen ufe) {
		
		super("Film erfassen");
		
		
		
		this.ufe = ufe;
		
		
		ok = new Buttons("Ok");
		a = new ActionHandler();
		
		gl1 = new GridLayout(4,2);
		fl = new FlowLayout();
		
		form = new ErfassPanel();
		buttons = new ErfassPanel();
		
		form.setLayout(gl1);
		buttons.setLayout(fl);
		
		ok.addActionListener(a);
		
		speichern = new Buttons("Speichern");
		abbrechen = new Buttons("Abbrechen");
		
		
		titel = new JTextField("Titel");
		jahr = new JTextField("Jahr");
		genre = new JTextField("Genre");
		beschreibung = new JTextField("Beschreibung");
		h�lle = new Buttons("Bild w�hlen");
		
		titelL = new ErfassLabel("Titel", SwingConstants.CENTER);
		jahrL = new ErfassLabel("Jahr", SwingConstants.CENTER);
		genreL = new ErfassLabel("Genre", SwingConstants.CENTER);
		beschreibungL = new ErfassLabel("Beschreibung", SwingConstants.CENTER);
		
		titel.addActionListener(a);
		jahr.addActionListener(a);
		genre.addActionListener(a);
		beschreibung.addActionListener(a);
		h�lle.addActionListener(a);
		
		speichern.addActionListener(a);
		abbrechen.addActionListener(a);

		form.add(titelL);
		form.add(titel);
		form.add(jahrL);
		form.add(jahr);
		form.add(genreL);
		form.add(genre);
		form.add(beschreibungL);
		form.add(beschreibung);
		
		buttons.add(abbrechen, BorderLayout.WEST);
		buttons.add(h�lle, BorderLayout.CENTER);
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
			
			if (e.getSource() == h�lle) {
				datei = new JFileChooser();
				datei.setName("Bild w�hlen");
				int result = datei.showOpenDialog(new JDialog());
				
				if (result == JFileChooser.APPROVE_OPTION) {
				    dateiname = datei.getSelectedFile().getName();
				}
				

				    
				datei.setVisible(true);
				datei.setSize(300, 300);
				
				
			}
			
			if (e.getSource() == ok) {
				zahl.dispose();
			}
			
			if (e.getSource() == speichern) {
				try {
					
					ufe.setTitel(titel.getText());
					ufe.setGenre(genre.getText());
					ufe.setJahr(Integer.parseInt(jahr.getText()));
					ufe.setBeschreibung(beschreibung.getText());
					ufe.setH�lle(dateiname);
					ufe.speichern();

					dispose();
					} catch (NumberFormatException exception) {
						zahl = new JDialog();
						zahl.setTitle("Bitte Zahl bei Jahr eingeben");
						zahl.setVisible(true);
						zahl.add(new ErfassLabel("Bitte Zahl bei Jahr eingeben!", SwingConstants.CENTER), BorderLayout.CENTER);
						zahl.add(ok, BorderLayout.SOUTH);
						zahl.setSize(300, 150);
						zahl.setLocationRelativeTo(null);
						zahl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					} catch (NullPointerException exception) {
						JDialog zahl = new JDialog();
						zahl.setTitle("Bitte Datei f�r H�lle ausw�hlen!");
						zahl.setVisible(true);
						zahl.add(new ErfassLabel("Bitte Datei f�r H�lle ausw�hlen!", SwingConstants.CENTER), BorderLayout.CENTER);
						zahl.add(ok, SwingConstants.SOUTH);
						zahl.setSize(300, 150);
						zahl.setLocationRelativeTo(null);
						zahl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					} 
			}
			
		}
		
	}

}
