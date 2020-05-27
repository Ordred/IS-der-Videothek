package gui;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JButton;

public class buttons extends JButton {



	public buttons(String titel) {


		setText(titel);
		setOpaque(true);
		setBackground(Color.red);
		setForeground(Color.white);
		
	}

	public buttons() {


		setOpaque(true);
		setBackground(Color.red);
		setForeground(Color.white);
		

	}

	public buttons(Icon icon) {

		setIcon(icon);
		setOpaque(false);
		setBackground(Color.red);
		setForeground(Color.white);

	}

}
