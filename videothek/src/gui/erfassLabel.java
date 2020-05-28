package gui;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JLabel;

public class erfassLabel extends JLabel {

	public erfassLabel(String titel, int position) {
		setText(titel);
		setOpaque(true);
		setBackground(Color.black);
		setForeground(Color.white);

		setHorizontalAlignment(position);




	}

	public erfassLabel(String titel) {
		setOpaque(true);
		setText(titel);
		setBackground(Color.black);
		setForeground(Color.white);


	}
	
	public erfassLabel(Icon icon) {
		setIcon(icon);
		setOpaque(true);
		
		setBackground(Color.black);
		setForeground(Color.white);


	}

}
