package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JLabel;

public class ErfassLabel extends JLabel {

	public ErfassLabel(String titel, int position) {
		setText(titel);
		setOpaque(true);
		setBackground(Color.black);
		setForeground(Color.white);

		setHorizontalAlignment(position);




	}

	public ErfassLabel(String titel) {
		setOpaque(true);
		setText(titel);
		setBackground(Color.black);
		setForeground(Color.white);


	}
	
	
	
	public ErfassLabel(Icon icon) {
		setIcon(icon);
		setOpaque(true);
		
		setBackground(Color.black);
		setForeground(Color.white);


	}

}
