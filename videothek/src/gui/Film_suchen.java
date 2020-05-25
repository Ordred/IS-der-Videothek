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

import filme.Film;
import filme.Filmliste;
import filme.UC_Film_suchen;
import filme.UC_Medium_erfassen;

public class Film_suchen extends JFrame {

	ArrayList<Film> suchergebnisse;
	ArrayList<JButton> suchergebnisseB;
	ArrayList<JLabel> suchergebnisseGenre;
	ArrayList<JLabel> suchergebnisseJahr;
	JPanel suchergebnisseP;
	JScrollPane sucheScroll;
	GridLayout sucheGL;
	boolean medium;
	private Film f;

	JLabel [] titelleiste;

	JDialog suche2;

	ActionHandler a;

	Film_anzeigen fa;

	JDialog nichtgefunden;
	JLabel nichtgefundenL;
	JButton ok;
	JPanel ngfPanel;

	String [] kriterien = {"Titel", "Jahr", "Genre", "Beschreibung"};

	UC_Film_suchen ucfs;
	UC_Medium_erfassen ucme;

	JComboBox<String> auswahl = new JComboBox<String>(kriterien);
	JLabel auswahlL;

	JTextField suchfeld;
	JLabel suchbegriffe;

	JButton suchen;
	JButton abbrechen;

	FlowLayout flow1;
	FlowLayout flow2;
	FlowLayout flow3;
	FlowLayout nichtgFL;

	GridLayout gl;

	JPanel menu;
	JPanel suche;
	JPanel buttons;

	public Film_suchen (UC_Film_suchen ucsf, boolean medium, UC_Medium_erfassen ucme) {

		super("Film suchen");
		gl = new GridLayout(3, 1);
		super.setLayout(gl);
		
		this.medium = medium;
		this.ucme = ucme;

		suche2 = new JDialog();


		suchergebnisse = new ArrayList<Film>();
		suchergebnisseB = new ArrayList<JButton>();
		suchergebnisseGenre = new ArrayList<JLabel>();
		suchergebnisseJahr = new ArrayList<JLabel>();
		titelleiste = new JLabel[3];
		titelleiste[0] = new JLabel("Titel", SwingConstants.CENTER);
		titelleiste[1] = new JLabel("Genre", SwingConstants.CENTER);
		titelleiste[2] = new JLabel("Jahr", SwingConstants.CENTER);
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

		this.ucfs = ucsf;

		auswahl.addActionListener(a);

		auswahlL = new JLabel("Auswahl");

		menu = new JPanel();
		suche = new JPanel();
		buttons = new JPanel();

		flow1 = new FlowLayout();
		flow2 = new FlowLayout();
		flow3 = new FlowLayout();

		suche.setLayout(flow1);
		buttons.setLayout(flow2);
		menu.setLayout(flow3);

		suchen = new JButton("Suchen");
		abbrechen = new JButton("Abbrechen");

		suchen.addActionListener(a);
		abbrechen.addActionListener(a);

		suchfeld = new JTextField("Suchbegriff eingeben");
		suchbegriffe = new JLabel("Suchbegriffe");

		suche.add(suchbegriffe, BorderLayout.WEST);
		suche.add(suchfeld, BorderLayout.CENTER);

		buttons.add(abbrechen, BorderLayout.WEST);
		buttons.add(suchen, BorderLayout.EAST);

		menu.add(auswahlL);
		menu.add(auswahl);



		add(menu, BorderLayout.NORTH);
		add(suche, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);


		nichtgefunden = new JDialog();
		nichtgefundenL = new JLabel("Es konnte kein Film mit diesen Angaben gefunden werden");
		nichtgFL = new FlowLayout();
		ok = new JButton ("Ok");
		ngfPanel = new JPanel();
		ngfPanel.setLayout(nichtgFL);
		ngfPanel.add(ok, BorderLayout.CENTER);
		ok.addActionListener(a);
		nichtgefunden.setTitle("Film nicht gefunden");
		nichtgefunden.add(nichtgefundenL, BorderLayout.CENTER);
		nichtgefunden.add(ngfPanel, BorderLayout.SOUTH);

		nichtgefunden.pack();
		nichtgefunden.setVisible(false);
		nichtgefunden.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

	}


	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (!medium) {

			for (int i = 0; i < suchergebnisseB.size(); i++) {
				if (e.getSource() == suchergebnisseB.get(i)) {
					fa = new Film_anzeigen(suchergebnisse.get(i));
					fa.setSize(400, 400);
					fa.setVisible(true);
					fa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
			}
			
			else {
				for (int i = 0; i < suchergebnisseB.size(); i++) {
					if (e.getSource() == suchergebnisseB.get(i)) {
						ucme.setFilm2(suchergebnisse.get(i));
						System.out.println("film gesetzt");
						suche2.dispose();
						dispose();
					}
				}
			}


			if (e.getSource() == suchen) {
				System.out.println("Suchen");

				if (auswahl.getSelectedItem() == "Titel") {
					suchergebnisse = ucfs.titel(suchfeld.getText());
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(suchergebnisse.size()+1, 3);

						suchergebnisseB.add(new JButton(suchergebnisse.get(i).getTitel()));
						suchergebnisseGenre.add(new JLabel(suchergebnisse.get(i).getGenre(), SwingConstants.CENTER));
						suchergebnisseJahr.add(new JLabel(Integer.toString(suchergebnisse.get(i).getJahr()), SwingConstants.CENTER));

						suchergebnisseB.get(i).setSize(300, 10);

						suchergebnisseB.get(i).setVisible(true);
						suchergebnisseB.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseB.get(i));
						suchergebnisseP.add(suchergebnisseGenre.get(i));
						suchergebnisseP.add(suchergebnisseJahr.get(i));
						suchergebnisseGenre.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseJahr.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseP.setLayout(sucheGL);
						suchergebnisseP.repaint();
						sucheScroll.repaint();
						repaint();
						System.out.println(suchergebnisseB.get(i).getText());
					}
				}


				if (auswahl.getSelectedItem() == "Jahr") {
					suchergebnisse = ucfs.jahr(Integer.parseInt(suchfeld.getText()));
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(3, suchergebnisse.size()+1);

						suchergebnisseB.add(new JButton(suchergebnisse.get(i).getTitel()));
						suchergebnisseGenre.add(new JLabel(suchergebnisse.get(i).getGenre(), SwingConstants.CENTER));
						suchergebnisseJahr.add(new JLabel(Integer.toString(suchergebnisse.get(i).getJahr()), SwingConstants.CENTER));

						suchergebnisseB.get(i).setSize(300, 10);

						suchergebnisseB.get(i).setVisible(true);
						suchergebnisseB.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseB.get(i));
						suchergebnisseP.add(suchergebnisseGenre.get(i));
						suchergebnisseP.add(suchergebnisseJahr.get(i));
						suchergebnisseGenre.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseJahr.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseP.setLayout(sucheGL);
						suchergebnisseP.repaint();
						sucheScroll.repaint();
						repaint();
						System.out.println(suchergebnisseB.get(i).getText());


					}
				}

				if (auswahl.getSelectedItem() == "Genre") {
					suchergebnisse = ucfs.genre(suchfeld.getText());
					for (int i = 0; i < suchergebnisse.size(); i++) {
						sucheGL = new GridLayout(3, suchergebnisse.size()+1);

						suchergebnisseB.add(new JButton(suchergebnisse.get(i).getTitel()));
						suchergebnisseGenre.add(new JLabel(suchergebnisse.get(i).getGenre(), SwingConstants.CENTER));
						suchergebnisseJahr.add(new JLabel(Integer.toString(suchergebnisse.get(i).getJahr()), SwingConstants.CENTER));

						suchergebnisseB.get(i).setSize(300, 10);

						suchergebnisseB.get(i).setVisible(true);
						suchergebnisseB.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseB.get(i));
						suchergebnisseP.add(suchergebnisseGenre.get(i));
						suchergebnisseP.add(suchergebnisseJahr.get(i));
						suchergebnisseGenre.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseJahr.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseP.setLayout(sucheGL);
						suchergebnisseP.repaint();
						sucheScroll.repaint();
						repaint();
						System.out.println(suchergebnisseB.get(i).getText());
					}
				}

				if (auswahl.getSelectedItem() == "Beschreibung") {
					suchergebnisse = ucfs.beschreibung(suchfeld.getText());
					for (int i = 0; i < suchergebnisse.size(); i++) {

						sucheGL = new GridLayout(3, suchergebnisse.size()+1);

						suchergebnisseB.add(new JButton(suchergebnisse.get(i).getTitel()));
						suchergebnisseGenre.add(new JLabel(suchergebnisse.get(i).getGenre(), SwingConstants.CENTER));
						suchergebnisseJahr.add(new JLabel(Integer.toString(suchergebnisse.get(i).getJahr()), SwingConstants.CENTER));

						suchergebnisseB.get(i).setSize(300, 10);

						suchergebnisseB.get(i).setVisible(true);
						suchergebnisseB.get(i).addActionListener(a);
						suchergebnisseP.add(suchergebnisseB.get(i));
						suchergebnisseP.add(suchergebnisseGenre.get(i));
						suchergebnisseP.add(suchergebnisseJahr.get(i));
						suchergebnisseGenre.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseJahr.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						suchergebnisseP.setLayout(sucheGL);
						suchergebnisseP.repaint();
						sucheScroll.repaint();
						repaint();
						System.out.println(suchergebnisseB.get(i).getText());

					}
				}

				if (suchergebnisse.size() > 0) {

					suche2 = new JDialog();
					suche2.setTitle("Suchergebnisse");
					suche2.add(sucheScroll);
					suche2.setVisible(true);
					suche2.setSize(600, 400);;
					suche2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				}

				else {
					nichtgefunden.setVisible(true);
				}
			}

			if (e.getSource() == abbrechen) {
				dispose();
			}

			if (e.getSource() == ok) {
				nichtgefunden.setVisible(false);
			}


			/*
					System.out.println("Titel Suche");
					try {
						fa = new Film_anzeigen(ucfs.titel(suchfeld.getText()));
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
}


