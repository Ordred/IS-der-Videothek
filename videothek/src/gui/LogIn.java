package gui;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import kunden.Kunde;
import kunden.Kundenliste;
import kunden.UC_Guthaben_aufladen;
import kunden.UC_Kunde_suchen;


public class LogIn extends JFrame {

		private ArrayList<JButton> suchergebnisseName;
		private ArrayList<JLabel> suchergebnisseVorname;
		private ArrayList<JLabel> suchergebnisseGeburtsdatum;
		private JPanel suchergebnisseP;
		private JScrollPane sucheScroll;
		private GridLayout sucheGL;

		private JLabel [] titelleiste;

		private ActionHandler a;

		private Kunde_anzeigen ka;
		
		private Kundenliste kl;



		private String [] kriterien = {"Name", "Vorname", "Geburtsdatum", "Lieblingsgenre"};




		private JComboBox<String> auswahl = new JComboBox<String>(kriterien);




		private GridLayout gl;
		
		private Hauptmenu_Besitzer hs;
		
		private JButton admin;


		public LogIn (UC_Kunde_suchen ucks, Kundenliste kl) {

			super("Kunde suchen");
			gl = new GridLayout(3, 1);
			super.setLayout(gl);
			

			kl = new Kundenliste();
			kl.laden();


			suchergebnisseName = new ArrayList<JButton>();
			suchergebnisseVorname = new ArrayList<JLabel>();
			suchergebnisseGeburtsdatum = new ArrayList<JLabel>();
			titelleiste = new JLabel[3];
			titelleiste[0] = new JLabel("Name", SwingConstants.CENTER);
			titelleiste[1] = new JLabel("Vorname", SwingConstants.CENTER);
			titelleiste[2] = new JLabel("Geburtadatum", SwingConstants.CENTER);
			suchergebnisseP = new JPanel();
			sucheGL = new GridLayout(20, 3);


			suchergebnisseP.setLayout(sucheGL);
			sucheScroll = new JScrollPane(suchergebnisseP,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			suchergebnisseP.add(titelleiste[0]);
			suchergebnisseP.add(titelleiste[1]);
			suchergebnisseP.add(titelleiste[2]);

			titelleiste[0].setBorder(BorderFactory.createLineBorder(Color.black));
			titelleiste[1].setBorder(BorderFactory.createLineBorder(Color.black));
			titelleiste[2].setBorder(BorderFactory.createLineBorder(Color.black));

			titelleiste[0].setOpaque(true);
			titelleiste[1].setOpaque(true);
			titelleiste[2].setOpaque(true);

			titelleiste[0].setBackground(Color.BLUE);
			titelleiste[0].setForeground(Color.WHITE);
			titelleiste[1].setBackground(Color.BLUE);
			titelleiste[1].setForeground(Color.WHITE);
			titelleiste[2].setBackground(Color.BLUE);
			titelleiste[2].setForeground(Color.WHITE);

			sucheScroll.setPreferredSize(new Dimension(300, 300));


			a = new ActionHandler();

			auswahl.addActionListener(a);
			
			sucheGL = new GridLayout(kl.getKundenliste().size()+2, 3);
			
			admin = new JButton("Admin");
			
			suchergebnisseName.add(admin);
			suchergebnisseVorname.add(new JLabel("Admin", SwingConstants.CENTER));
			suchergebnisseGeburtsdatum.add(new JLabel ("Admin", SwingConstants.CENTER));

			for (int i = 0; i < kl.getKundenliste().size(); i++) {
				

				suchergebnisseName.add(new JButton(kl.getKundenliste().get(i).getName()));
				suchergebnisseVorname.add(new JLabel(kl.getKundenliste().get(i).getVorname(), SwingConstants.CENTER));
				suchergebnisseGeburtsdatum.add(new JLabel(kl.getKundenliste().get(i).getGeburtsdatum(), SwingConstants.CENTER));

				suchergebnisseName.get(i).setSize(300, 10);

				suchergebnisseName.get(i).setVisible(true);
				suchergebnisseName.get(i).addActionListener(a);
				suchergebnisseP.add(suchergebnisseName.get(i));
				suchergebnisseP.add(suchergebnisseVorname.get(i));
				suchergebnisseP.add(suchergebnisseGeburtsdatum.get(i));
				suchergebnisseVorname.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
				suchergebnisseGeburtsdatum.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
				suchergebnisseP.setLayout(sucheGL);
				suchergebnisseP.repaint();
				sucheScroll.repaint();
				repaint();
				System.out.println(suchergebnisseName.get(i).getText());
			}

		}



		public class ActionHandler implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				if (e.getSource() == admin) {
					hs = new Hauptmenu_Besitzer();
					hs.setVisible(true);
					hs.setSize(500, 500);
					hs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}




				/*
						System.out.println("Titel Suche");
						try {
							fa = new Kunde_anzeigen(ucfs.titel(suchfeld.getText()));
							fa.setVisible(true);
							fa.setSize(400, 400);
							fa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						} catch (NullPointerException exception) {

							nichtgefunden.setVisible(true);
						}

					}

					if (auswahl.getSelectedItem() == "Jahr") {
						suchergebnisse = ucfs.jahr(Integer.parseInt(suchfeld.getText()));
						for (int i = 0; i < suchergebnisse.size(); i++) {

							suchergebnisseL.add(new JButton(suchergebnisse.get(i).getJahr()+"\t"+
									suchergebnisse.get(i).getGenre()+"\t"+suchergebnisse.get(i).getJahr()));

						}

						if (auswahl.getSelectedItem() == "Genre") {
							suchergebnisse = ucfs.genre(suchfeld.getText());
							for (int i = 0; i < suchergebnisse.size(); i++) {

								suchergebnisseL.add(new JButton(suchergebnisse.get(i).getTitel()+"\t"+
										suchergebnisse.get(i).getGenre()+"\t"+suchergebnisse.get(i).getJahr()));

							}

							if (auswahl.getSelectedItem() == "Beschreibung") {
								suchergebnisse = ucfs.beschreibung(suchfeld.getText());
								for (int i = 0; i < suchergebnisse.size(); i++) {

									suchergebnisseL.add(new JButton(suchergebnisse.get(i).getTitel()+"\t"+
											suchergebnisse.get(i).getGenre()+"\t"+suchergebnisse.get(i).getJahr()));

								}		

							}
				 */



			}
			
		}
		
		/*
		public static void main(String[] args) {
			
		}
		
		*/
	}
