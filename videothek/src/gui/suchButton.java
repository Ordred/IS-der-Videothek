package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;


public class suchButton extends JButton {

	
	public suchButton( String titel) {
		setText(titel);
		
		Font f = new Font("Arial",3,16);
		
		setOpaque(true);
		setBackground(Color.red);
		setForeground(Color.white);
		setFont(f);
		
		
	}
}
