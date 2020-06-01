package gui;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;


import controller.UC_Guthaben_aufladen;
import controller.UC_Kunde_suchen;
import gui_elemente.Buttons;
import gui_elemente.ErfassLabel;
import gui_elemente.ErfassPanel;
import gui_elemente.SuchButton;
import gui_elemente.SuchFrame;
import gui_elemente.SuchLabel;
import model.Filmliste;
import model.Kunde;
import model.Kundenliste;
import model.Medienliste;


public class LogIn extends SuchFrame {

		private ArrayList<JButton> name;
		private ArrayList<JLabel> vorname;
		private ArrayList<JLabel> geburtsdatum;
		private ErfassPanel nutzerP;
		private JScrollPane nutzerPane;
		private GridLayout loginGL;

		private JLabel [] titelleiste;

		private ActionHandler a;

		private Kunde_anzeigen ka;
		
		private Kundenliste kl;

		private GridLayout gl;
		
		private Hauptmenu_Besitzer hs;
		
		private JButton admin;
		
		private Kunde k;
		
		private Hauptmenu_Kunde hk;
		
		private Filmliste fl;
		
		private Medienliste ml;


		public LogIn () {

			super("Login");
			gl = new GridLayout(2, 1);
			super.setLayout(gl);
			
			ErfassPanel adminP = new ErfassPanel(new FlowLayout());
			
			kl = new Kundenliste();
			kl.laden();


			name = new ArrayList<JButton>();
			vorname = new ArrayList<JLabel>();
			geburtsdatum = new ArrayList<JLabel>();
			titelleiste = new ErfassLabel[3];
			titelleiste[0] = new ErfassLabel("Name", SwingConstants.CENTER);
			titelleiste[1] = new ErfassLabel("Vorname", SwingConstants.CENTER);
			titelleiste[2] = new ErfassLabel("Geburtsdatum", SwingConstants.CENTER);
			nutzerP = new ErfassPanel();
			loginGL = new GridLayout(20, 3);


			nutzerP.setLayout(loginGL);
			
			for (int i = 0; i < titelleiste.length; i++) {


				titelleiste[i].setOpaque(true);
				titelleiste[i].setFont(new Font("Arial", 1, 15));
				titelleiste[i].setBackground(Color.gray);
				titelleiste[i].setForeground(Color.white);

			}

			a = new ActionHandler();

				
			loginGL = new GridLayout(kl.getKundenliste().size()+1, 3);
			
			admin = new Buttons("Admin");
			admin.addActionListener(a);
			adminP.add(admin);
			
			
			nutzerP.add(titelleiste[0]);
			nutzerP.add(titelleiste[1]);
			nutzerP.add(titelleiste[2]);
			
			
			
			System.out.println(kl);
			
			

			for (int i = 0; i < kl.getKundenliste().size(); i++) {
				
				System.out.println(kl.getKundenliste().get(i).getName());

				name.add(new SuchButton(kl.getKundenliste().get(i).getName()));
				vorname.add(new SuchLabel(kl.getKundenliste().get(i).getVorname(), SwingConstants.CENTER));
				geburtsdatum.add(new SuchLabel(kl.getKundenliste().get(i).getGeburtsdatum(), SwingConstants.CENTER));

				name.get(i).setFont(new Font("Arial", 1, 14));
				vorname.get(i).setFont(new Font("Arial", 1, 13));
				geburtsdatum.get(i).setFont(new Font("Arial", 1, 13));
				
				name.get(i).addActionListener(a);
				
				nutzerP.add(name.get(i));
				nutzerP.add(vorname.get(i));
				nutzerP.add(geburtsdatum.get(i));
				
				nutzerP.setLayout(loginGL);
				nutzerP.repaint();
				repaint();
				System.out.println(name.get(i).getText());
				
			} 
			
			nutzerPane = new JScrollPane(nutzerP,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			nutzerPane.setPreferredSize(new Dimension(300, 300));
			
			
			
			add(admin, BorderLayout.SOUTH);
			if (kl.getKundenliste().size() > 0) {
			add(nutzerPane, BorderLayout.CENTER);
			}
			else {
				add(new ErfassLabel("Noch keine Kunden in der Datenbank", SwingConstants.CENTER), BorderLayout.CENTER);
			}
			validate();
			repaint();
			

		}



		public class ActionHandler implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				if (e.getSource() == admin) {
					hs = new Hauptmenu_Besitzer(null);
					hs.setVisible(true);
					hs.setSize(500, 500);
					hs.setLocationRelativeTo(null);
					hs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
				}
				
				for (int i = 0; i < name.size(); i++) {
					if (e.getSource() == name.get(i)) {
						k = kl.getKundenliste().get(i);
						hk = new Hauptmenu_Kunde(k);
						hk.setVisible(true);
						hk.setSize(500, 500);
						hk.setLocationRelativeTo(null);
						hk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						
					}
				}




				/*
						System.out.println("Titel Suche");
						try {
							fa = new Kunde_anzeigen(hk.titel(suchfeld.getText()));
							fa.setVisible(true);
							fa.setSize(400, 400);
							fa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						} catch (NullPointerException exception) {

							nichtgefunden.setVisible(true);
						}

					}

					if (auswahl.getSelectedItem() == "Jahr") {
						suchergebnisse = hk.jahr(Integer.parseInt(suchfeld.getText()));
						for (int i = 0; i < suchergebnisse.size(); i++) {

							suchergebnisseL.add(new JButton(suchergebnisse.get(i).getJahr()+"\t"+
									suchergebnisse.get(i).getGenre()+"\t"+suchergebnisse.get(i).getJahr()));

						}

						if (auswahl.getSelectedItem() == "Genre") {
							suchergebnisse = hk.genre(suchfeld.getText());
							for (int i = 0; i < suchergebnisse.size(); i++) {

								suchergebnisseL.add(new JButton(suchergebnisse.get(i).getTitel()+"\t"+
										suchergebnisse.get(i).getGenre()+"\t"+suchergebnisse.get(i).getJahr()));

							}

							if (auswahl.getSelectedItem() == "Beschreibung") {
								suchergebnisse = hk.beschreibung(suchfeld.getText());
								for (int i = 0; i < suchergebnisse.size(); i++) {

									suchergebnisseL.add(new JButton(suchergebnisse.get(i).getTitel()+"\t"+
											suchergebnisse.get(i).getGenre()+"\t"+suchergebnisse.get(i).getJahr()));

								}		

							}
				 */



			}
			
		}
		
	
		
		
		public static void main(String[] args) {
			
			LogIn l = new LogIn();
			l.setVisible(true);
			l.setSize(400, 400);
			l.setLocationRelativeTo(null);
			l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			l.setLocationRelativeTo(null);
			/*
			Hauptmenu_Besitzer hs = new Hauptmenu_Besitzer(null);
			hs.setVisible(true);
			hs.setSize(500, 500);
			hs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			hs.setLocationRelativeTo(null);
			*/
			
			
		}
		
		
	}
