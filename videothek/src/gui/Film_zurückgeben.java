package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import controller.UC_Film_zurückgeben;
import controller.UC_Medium_suchen;

import model.Kunde;
import model.Kundenliste;
import model.Medienliste;
import model.Medium;

public class Film_zurückgeben extends JFrame {

	private Kunde k;
	private UC_Film_zurückgeben ucfz;



	private ArrayList<Medium> ml;

	private ArrayList<suchButton> medienB;
	private ArrayList<suchLabel> medium;
	private ArrayList<suchLabel> titel;
	private ArrayList<suchLabel> genre;
	private ArrayList<suchLabel> jahr;

	private erfassPanel mlPanel;

	private GridLayout gl;

	private JScrollPane sucheScroll;

	private ActionHandler a;

	private JLabel [] titelleiste;

	private Medium m;
	
	private buttons ok;
	
	private JDialog zurückgegeben;




	public Film_zurückgeben(Kunde k, UC_Film_zurückgeben ucfz) {

		this.k = k;

		
		
		ml = k.getAusleihliste();
		this.ucfz = ucfz;
		
		

		System.out.println(ml);
		
		ok = new buttons("Ok");
		
		ActionHandler a = new ActionHandler();
		
		ok.addActionListener(a);


		medienB = new ArrayList<suchButton>();
		medium = new ArrayList<suchLabel>();
		titel = new ArrayList<suchLabel>();
		genre = new ArrayList<suchLabel>();
		jahr = new ArrayList<suchLabel>();
		titelleiste = new JLabel[5];
		titelleiste[0] = new JLabel("ID", SwingConstants.CENTER);
		titelleiste[1] = new JLabel("Medium", SwingConstants.CENTER);
		titelleiste[2] = new JLabel("Titel", SwingConstants.CENTER);
		titelleiste[3] = new JLabel("Genre", SwingConstants.CENTER);
		titelleiste[4] = new JLabel("Jahr", SwingConstants.CENTER);
		mlPanel = new erfassPanel();
		gl = new GridLayout(20, 3);


		mlPanel.setLayout(gl);
		sucheScroll = new JScrollPane(mlPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		mlPanel.add(titelleiste[0]);
		mlPanel.add(titelleiste[1]);
		mlPanel.add(titelleiste[2]);
		mlPanel.add(titelleiste[3]);
		mlPanel.add(titelleiste[4]);

		for (int i = 0; i < titelleiste.length; i++) {


			titelleiste[i].setOpaque(true);
			titelleiste[i].setFont(new Font("Arial", 3, 40));
			titelleiste[i].setBackground(Color.gray);
			titelleiste[i].setForeground(Color.white);

		}





		for (int i = 0; i < ml.size(); i++) {
			gl = new GridLayout(ml.size()+1, 5);


			medienB.add(new suchButton(Integer.toString(ml.get(i).getId())));
			medium.add(new suchLabel(ml.get(i).getMedium(), SwingConstants.CENTER));
			titel.add(new suchLabel(ml.get(i).getFilm().getTitel(), SwingConstants.CENTER));
			genre.add(new suchLabel(ml.get(i).getFilm().getGenre(), SwingConstants.CENTER));
			jahr.add(new suchLabel(Integer.toString(ml.get(i).getFilm().getJahr()), SwingConstants.CENTER));

			medienB.get(i).setSize(300, 10);

			medienB.get(i).setVisible(true);
			medienB.get(i).addActionListener(a);
			mlPanel.add(medienB.get(i));
			mlPanel.add(medium.get(i));
			mlPanel.add(titel.get(i));
			mlPanel.add(genre.get(i));
			mlPanel.add(jahr.get(i));
			medium.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
			titel.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
			genre.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
			jahr.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
			mlPanel.setLayout(gl);
			mlPanel.repaint();
			sucheScroll.repaint();

			System.out.println(medienB.get(i).getText());
		}


		add(sucheScroll);


	}


	public class ActionHandler implements ActionListener {



		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == ok) {
				zurückgegeben.dispose();
			}

			for (int i = 0; i < medienB.size(); i++) {
				if (e.getSource() == medienB.get(i)) {
					ucfz.zurückgeben(i);
					
					zurückgegeben = new JDialog();
					
					zurückgegeben.setTitle("Film zurückgegeben");
					zurückgegeben.setVisible(true);
					zurückgegeben.setSize(300, 150);
					zurückgegeben.setBackground(Color.black);
					zurückgegeben.setLocationRelativeTo(null);
					zurückgegeben.add(new erfassLabel("Danke! Film erfolgreich zurückgegeben!"), BorderLayout.CENTER);
					zurückgegeben.add(ok, BorderLayout.SOUTH);
					dispose();
				}
			}

		}

	}
}
