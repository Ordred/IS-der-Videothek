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
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.UC_Film_erfassen;

public class Film_Erfassen extends erfassFrame{

	/* JFilechooser */
	
	private UC_Film_erfassen ufe;
	
	private JTextField titel;
	private JTextField jahr;
	private JTextField genre;
	private JTextField beschreibung;
	private buttons hülle;
	
	private erfassLabel titelL;
	private erfassLabel jahrL;
	private erfassLabel genreL;
	private erfassLabel beschreibungL;
	private erfassLabel hülleL;
	
	private erfassPanel buttons;
	private erfassPanel form;
	
	private GridLayout gl1;
	
	private FlowLayout fl;
	
	private buttons speichern;
	private buttons abbrechen;
	
	private ActionHandler a;
	
	private String dateiname;
	
	private JFileChooser datei;
	
	private File ic;
	
	
	public Film_Erfassen(UC_Film_erfassen ufe) {
		
		super("Film erfassen");
		
		setLocationRelativeTo(null);
		
		this.ufe = ufe;
		
		
		
		a = new ActionHandler();
		
		gl1 = new GridLayout(4,2);
		fl = new FlowLayout();
		
		form = new erfassPanel(null);
		buttons = new erfassPanel(null);
		
		form.setLayout(gl1);
		buttons.setLayout(fl);
		
		speichern = new buttons("Speichern");
		abbrechen = new buttons("Abbrechen");
		
		
		titel = new JTextField("Titel");
		jahr = new JTextField("Jahr");
		genre = new JTextField("Genre");
		beschreibung = new JTextField("Beschreibung");
		hülle = new buttons("Bild wählen");
		
		titelL = new erfassLabel("Titel", SwingConstants.CENTER);
		jahrL = new erfassLabel("Jahr", SwingConstants.CENTER);
		genreL = new erfassLabel("Genre", SwingConstants.CENTER);
		beschreibungL = new erfassLabel("Beschreibung", SwingConstants.CENTER);
		
		titel.addActionListener(a);
		jahr.addActionListener(a);
		genre.addActionListener(a);
		beschreibung.addActionListener(a);
		hülle.addActionListener(a);
		
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
		buttons.add(hülle, BorderLayout.CENTER);
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
			
			if (e.getSource() == hülle) {
				datei = new JFileChooser();
				datei.setName("Bild wählen");
				int result = datei.showOpenDialog(new JDialog());
				
				if (result == JFileChooser.APPROVE_OPTION) {
				    ic = datei.getSelectedFile();
				}
				
				System.out.println(ic.getName());
				    
				datei.setVisible(true);
				datei.setSize(300, 300);
				
				
			}
			
			if (e.getSource() == speichern) {
				dateiname = ic.getName();
				ufe.setTitel(titel.getText());
				ufe.setGenre(genre.getText());
				ufe.setJahr(Integer.parseInt(jahr.getText()));
				ufe.setBeschreibung(beschreibung.getText());
				ufe.setHülle(ic.getName());
				ufe.speichern();

				dispose();
			}
			
		}
		
	}

}
