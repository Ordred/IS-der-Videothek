package gui_elemente;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;


public class SuchButton extends JButton {

	
	public SuchButton( String titel) {
		setText(titel);
		
		Font f = new Font("Arial",1,19);
		
		setOpaque(true);
		setBackground(Color.red);
		setForeground(Color.white);
		setFont(f);
		
		
	}
}
