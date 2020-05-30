package gui_elemente;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JButton;

public class Buttons extends JButton {



	public Buttons(String titel) {


		setText(titel);
		setOpaque(true);
		setBackground(Color.gray);
		setForeground(Color.white);
		
	}

	public Buttons() {


		setOpaque(true);
		setBackground(Color.gray);
		setForeground(Color.white);
		

	}

	public Buttons(Icon icon) {

		setIcon(icon);
		setOpaque(false);
		setBackground(Color.gray);
		setForeground(Color.white);

	}

}
